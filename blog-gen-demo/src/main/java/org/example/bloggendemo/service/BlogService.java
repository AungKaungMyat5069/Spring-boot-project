package org.example.bloggendemo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.bloggendemo.dao.CategoryDao;
import org.example.bloggendemo.dao.PostDao;
import org.example.bloggendemo.dao.UserDao;
import org.example.bloggendemo.entity.Category;
import org.example.bloggendemo.entity.Post;
import org.example.bloggendemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final CategoryDao categoryDao;
    private final PostDao postDao;
    private final UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void saveCategory(Category category) {
        categoryDao.save(category);
    }

    public List<Category> allCategory() {
        return categoryDao.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void savePost(Post post) {
        Category category = getCategoryById(post.getCategory().getId());
        User user = userDao.findById(post.getUser().getId()).orElseThrow(EntityNotFoundException::new);
        post.setUser(user);
        post.setCategory(category);
        postDao.save(post);
    }

    public List<Post> allPost() {
        return postDao.findAll();
    }

    public List<User> allUser() {
        return userDao.findAll();
    }
}
