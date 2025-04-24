package org.example.affablebeanui.controller;

import org.example.affablebeanui.dto.*;
import org.example.affablebeanui.services.CartService;
import org.example.affablebeanui.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/affableBean")
public class ProductController {

    private final ProductService productService;
    private final CartService cartService;
    private int categoryIdG;

    public ProductController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/test")
    public void test() {
        productService.getAllProducts()
                .forEach(System.out::println);
    }

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/view-products/category/{id}")
    public String viewProducts(@PathVariable(name = "id") Integer categoryId, Model model) {
        // Note Model is spring.ui package
        List<ProductDto> productsByCategoryID = productService.getProductsByCategoryID(categoryId);
        model.addAttribute("productsByCategoryId", productsByCategoryID);
        this.categoryIdG = categoryId;
        return "product";
    }



    @ModelAttribute("cartSize")
    public int getCartSize() {
        return cartService.cartCount();
    }


    @GetMapping("/cartItem/{id}")
    public String addCart(@PathVariable("id") int productId) {
        cartService.addCart(productId);
        return "redirect:/ui/affableBean/view-products/category/" + categoryIdG;
    }

    @GetMapping("/cart-view")
    public String cartView(Model model) {
        model.addAttribute("cartItems", cartService.getCarts());
        model.addAttribute("cartItem", new CartDto());
        model.addAttribute("renderer", model.containsAttribute("renderer"));
        //Note containsAttribute is using RedirectAttribute variable
        return "cart";
    }

    @GetMapping("/cartItem-delete")
    public String cartItemDelete(Integer productId) {
        cartService.removeCart(productId);
        return "redirect:/ui/affableBean/cart-view";
    }

    @GetMapping("/cartItem-clear")
    public String cartItemClear() {
        cartService.clearCart();
        return "redirect:/ui/affableBean/cart-view";
    }

    @PostMapping("/checkout")
    public String checkout(CartDto cartDto, RedirectAttributes redirectAttributes) {
//        cartDto.getQuantityList().forEach(System.out::println);

        int counter = 0;
        for (CartDto cartDto1 : cartService.getCarts()) {
            // If you don't know get() method, you are completely don't understand array api
            cartDto1.setQuantity(cartDto.getQuantityList().get(counter));
            cartDto1.setRender(true);
            counter++;
        }
        redirectAttributes.addFlashAttribute("renderer", true); // New Argument
        // Note addFlashAttribute is change value after refreshing like page is same but value is different after refresh
//        this.cartService.getCarts().forEach(System.out::println);
        return "redirect:/ui/affableBean/cart-view";
    }

    @ModelAttribute("CartItemCount")
    public int getCartItemCount() {
        return cartService.getCarts()
                .stream()
                .map(CartDto::getQuantity)
                .reduce(0, Integer::sum);
    }

    @ModelAttribute("TotalPrice")
    public double getTotalPrice() {
        return cartService.getCarts()
                .stream()
                .map(c -> c.getPrice().doubleValue() *  c.getQuantity())
                .reduce(0.0, Double::sum);
    }

    @GetMapping("/checkout-view")
    public String checkoutView(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "checkout";
    }

    @PostMapping("/buy-transaction")
    public String buyTransaction(UserDto userDto, @ModelAttribute("TotalPrice") double amount) {
        RequestDataDto requestDataDto = new RequestDataDto(userDto.getCreditCardNumber(), userDto.getName(), amount + 3);
        productService.buyTransaction(requestDataDto);
        //new line ### save bill/invoice

        productService.saveProductOrderToBackend(orderDetail(userDto));
        return "success";
    }

    private OrderDetailDto orderDetail(UserDto userDto) {
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setOrderNumber(ProductService.generateRandomNumber());
        orderDetailDto.setName(userDto.getName());
        orderDetailDto.setProducts(getAllCartItem());
        orderDetailDto.setEmail(userDto.getEmail());
        orderDetailDto.setAddress(userDto.getAddress());
        orderDetailDto.setPhoneNumber(userDto.getPhoneNumber());
        return orderDetailDto;
    }

    private Set<CartItemDto> getAllCartItem() {
        return cartService.getCarts()
                .stream().map(
                        c -> new CartItemDto(c.getName(), c.getPrice(), c.getQuantity())
                ).collect(Collectors.toSet());
    }
}
