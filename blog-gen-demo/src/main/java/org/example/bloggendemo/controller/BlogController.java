package org.example.bloggendemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.bloggendemo.entity.Category;
import org.example.bloggendemo.entity.Post;
import org.example.bloggendemo.entity.User;
import org.example.bloggendemo.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("post", new Post());
        model.addAttribute("user", new User());
        model.addAttribute("categories", blogService.allCategory());
        model.addAttribute("users", blogService.allUser());
        return "pages/home";
    }

    //category
    @GetMapping("/category")
    public String category(Model model) {
        model.addAttribute("categories", blogService.allCategory());
        return "pages/category";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/home";
        }
        blogService.saveCategory(category);
        return "redirect:/home";

    }

    @GetMapping("/update-category")
    public void findCategoryById(Model model, @RequestParam("id") int id) {
        model.addAttribute("category", blogService.getCategoryById(id));
    }

    //Post
    @PostMapping("/save-post")
    public String savePost(Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/home";
        }
        blogService.savePost(post);
        return "redirect:/home";
    }

    @GetMapping("/post")
    public String allPost(Model model) {
        model.addAttribute("posts", blogService.allPost() );
        return "pages/post";
    }

    //User
    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("users", blogService.allUser());
        return "pages/user";
    }

    @PostMapping("/save-user")
    public String saveUser(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/home";
        }
        blogService.saveUser(user);
        return "redirect:/home";
    }
}
