package com.example.recipesbackend;

import com.example.recipesbackend.dao.RecipeDao;
import com.example.recipesbackend.dto.RecipeDto;
import com.example.recipesbackend.entity.Recipe;
import com.example.recipesbackend.util.EntityUtil;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

@SpringBootApplication
public class RecipesBackendApplication {

	private final RestClient restClient;
	private final RecipeDao recipeDao;

	public RecipesBackendApplication(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
		this.restClient = RestClient.builder().baseUrl("http://localhost:3000").build();
	}

	public static void main(String[] args) {
		SpringApplication.run(RecipesBackendApplication.class, args);
	}


	private List<RecipeDto> getAllRecipes() {
		return restClient.get()
				.uri("/recipe")
				.retrieve()
				.body(new ParameterizedTypeReference<List<RecipeDto>>() {
				});
	}

	@Bean @Transactional
	@Profile("dev")
	public ApplicationRunner init() {
		return args -> {
//			getAllRecipes().forEach(System.out::println); //Don't use lombok in IJ
			getAllRecipes().stream().map(EntityUtil::toEntity).forEach(
					recipe -> {
						if(recipeDao.existsById(recipe.getId())) {
							recipeDao.save(recipe);
						}
					}
			);

//			Recipe recipe = new Recipe(null, "something","30", "35", 10, List.of("meat", "milk"), List.of("step1", "step2"), "somehting.jpg");
//			recipeDao.save(recipe);



		};
	}
}
