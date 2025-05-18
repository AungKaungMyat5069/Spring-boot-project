package org.example.foodiebackend;

import org.example.foodiebackend.dao.DishDao;
import org.example.foodiebackend.dao.RestaurantCategoryDao;
import org.example.foodiebackend.dao.RestaurantDao;
import org.example.foodiebackend.entity.Dish;
import org.example.foodiebackend.entity.Restaurant;
import org.example.foodiebackend.entity.RestaurantCategory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class FoodieBackendApplication {

    private final DishDao dishDao;
    private final RestaurantDao restaurantDao;
    private final RestaurantCategoryDao restaurantCategoryDao;

    public FoodieBackendApplication(DishDao dishDao, RestaurantDao restaurantDao, RestaurantCategoryDao restaurantCategoryDao) {
        this.dishDao = dishDao;
        this.restaurantDao = restaurantDao;
        this.restaurantCategoryDao = restaurantCategoryDao;
    }


    public static void main(String[] args) {
        SpringApplication.run(FoodieBackendApplication.class, args);
    }


    @Bean
    @Transactional
    @Profile("dev")
    public ApplicationRunner init() {
        return args -> {

            RestaurantCategory restaurantCategory1 = new RestaurantCategory("Korean Restaurant");
            RestaurantCategory restaurantCategory2 = new RestaurantCategory("Chinese Restaurant");

            Restaurant restaurant1 = new Restaurant("Alpha Shop", "alpha@gmail.com", "46th street, Botahtaung", "111222331", LocalTime.of(9, 0), LocalTime.of(17, 0));
            Restaurant restaurant2 = new Restaurant("Beta Shop", "beta@gmail.com", "1st street, Ye Kyaw", "111222332", LocalTime.of(6, 0), LocalTime.of(14, 0));
            Restaurant restaurant3 = new Restaurant("Gema Shop", "gema@gmail.com", "Main Road, Sula", "111222333", LocalTime.of(9, 0), LocalTime.of(17, 0));

            Dish dish1=new Dish("Yorkshire Lamb Patties",
                    "Lamb patties which melt in your mouth, and are quick and easy to make. Served hot with a crisp salad.",14.00,"62908867a48e4.jpg");
            Dish dish2=new Dish("Lobster Thermidor","Lobster Thermidor is a French dish of lobster meat cooked in a rich wine sauce, stuffed back into a lobster shell, and browned.",
                    36.00,"629089fee52b9.jpg");
            Dish dish3=new Dish("Chicken Madeira",
                    "Chicken Madeira, like Chicken Marsala, is made with chicken, mushrooms, and a special fortified wine. But, the wines are different",
                    23.0,"62908bdf2f581.jpg");
            Dish dish4=new Dish("Stuffed Jacket Potatoes",
                    "Deep fry whole potatoes in oil for 8-10 minutes or coat each potato with little oil. Mix the onions, garlic, tomatoes and mushrooms. Add yoghurt, ginger, garlic, chillies, coriander",8.00,
                    "62908d393465b.jpg");
            Dish dish5=new Dish("Pink Spaghetti Gamberoni",
                    "Spaghetti with prawns in a fresh tomato sauce. This dish originates from Southern Italy and with the combination of prawns, garlic, chilli and pasta. Garnish each with remaining tablespoon parsley.",21.00,
                    "606d7491a9d13.jpg");
            Dish dish6=new Dish("Cheesy Mashed Potato","Deliciously Cheesy Mashed Potato. The ultimate mash for your Thanksgiving table or the perfect accompaniment to vegan sausage casserole. Everyone will love it\\'s fluffy",
                    5.0,"606d74c416da5.jpg");
            Dish dish7=new Dish("Crispy Chicken Strips","Fried chicken strips, served with special honey mustard sauce.",
                    8.0,"606d74f6ecbbb.jpg");
            Dish dish8=new Dish("Lemon Grilled Chicken And Pasta",
                    "Marinated rosemary grilled chicken breast served with mashed potatoes and your choice of pasta.",
                    11.00,"606d752a209c3.jpg");
            Dish dish9=new Dish("Vegetable Fried Rice",
                    "Chinese rice wok with cabbage, beans, carrots, and spring onions.",
                    5.00,"606d7575798fb.jpg");
            Dish dish10=new Dish("Prawn Crackers",
                    "12 pieces deep-fried prawn crackers",
                    7.00,"606d75a7e21ec.jpg");
            Dish dish11=new Dish("Spring Rolls",
                    "Lightly seasoned shredded cabbage, onion and carrots, wrapped in house made spring roll wrappers, deep fried to golden brown.",
                    6.00,"606d75ce105d0.jpg");
            Dish dish12=new Dish("Manchurian Chicken",
                    "Chicken pieces slow cooked with spring onions in our house made manchurian style sauce.",
                    11.0,"606d7600dc54c.jpg"
            );
            Dish dish13=new Dish("Buffalo Wings",
                    "Fried chicken wings tossed in spicy Buffalo sauce served with crisp celery sticks and Blue cheese dip.",
                    11.00,"606d765f69a19.jpg");
            Dish dish14=new Dish("Mac N Cheese Bites",
                    "Served with our traditional spicy queso and marinara sauce.",9.0,"606d768a1b2a1.jpg");
            Dish dish15=new Dish("Signature Potato Twisters",
                    "Spiral sliced potatoes, topped with our traditional spicy queso, Monterey Jack cheese, pico de gallo, sour cream and fresh cilantro.",
                    6.0,"606d76ad0c0cb.jpg");
            Dish dish16=new Dish("Meatballs Penne Pasta",
                    "Garlic-herb beef meatballs tossed in our house-made marinara sauce and penne pasta topped with fresh parsley.",
                    10.00,"606d76eedbb99.jpg");

            List<Dish> dishesForRestaurant1 = List.of(dish1, dish2, dish3, dish4, dish5);
            for (Dish dish : dishesForRestaurant1) {
                restaurant1.addDish(dish);
            }

            List<Dish> dishesForRestaurant2 = List.of(dish6, dish7, dish8, dish9, dish10);
            for (Dish dish : dishesForRestaurant2) {
                restaurant2.addDish(dish);
            }

            List<Dish> dishesForRestaurant3 = List.of(dish11, dish12, dish13, dish14, dish15, dish16);
            for (Dish dish : dishesForRestaurant3) {
                restaurant3.addDish(dish);
            }

            restaurantCategory1.addRestaurant(restaurant1);
            restaurantCategory2.addRestaurant(restaurant2);
            restaurantCategory1.addRestaurant(restaurant3);

            restaurantCategoryDao.save(restaurantCategory1);
            restaurantCategoryDao.save(restaurantCategory2);
        };
    }
}
