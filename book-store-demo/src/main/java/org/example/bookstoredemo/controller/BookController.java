package org.example.bookstoredemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookstoredemo.entity.Book;
import org.example.bookstoredemo.service.BookService;
import org.example.bookstoredemo.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final CartService cartService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @ModelAttribute("images")
    public List<String> images() {
        return bookService.getAllBooks().stream().map(Book::getImgUrl).toList();
    }

    @GetMapping("/book-list")
    public String bookList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "book";
    }

    @GetMapping("/book")
    public String book(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "bookId";
    }

    @GetMapping("/add-cart")
    public String addCart(@RequestParam("id") Integer id) {
        cartService.addCartItem(id);
        return "redirect:/book-list";
    }

    @ModelAttribute("cartSize")
    public int cartSize() {
        return cartService.getCartItemCount();
    }

    @GetMapping("/cart-View")
    public String cartView( Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "cartView";
    }

    @ModelAttribute("totalPrice")
    public double totalPrice() {
      return cartService.totalPrice();
    }

    @GetMapping("/delete-cartItem")
    public String deleteCartItem(@RequestParam("id") Integer id) {
        cartService.removeCartItem(id);
        return "redirect:/cart-View";
    }
}
