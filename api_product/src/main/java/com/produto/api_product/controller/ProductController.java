package com.produto.api_product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.produto.api_product.model.Product;
import com.produto.api_product.model.ProductRepository;

@Controller
public class ProductController {
    
    @Autowired
    private ProductRepository repository;

    @GetMapping("/")
    private String productList (Model model){

        model.addAttribute("products", repository.findAll());
        return "index";

    }

    @GetMapping("/cadastro")
    public String showFormulary(Model model){

        model.addAttribute("product", new Product());
        return "cadastro";

    }

    @PostMapping("/cadastro")
    public String register(Product product){

        repository.save(product);
        return "redirect:/";

    }

}
