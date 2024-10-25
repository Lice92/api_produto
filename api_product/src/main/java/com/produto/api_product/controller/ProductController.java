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

    @GetMapping("/listar")
    private String productList (Model model){

        model.addAttribute("products", repository.findAll());
        return "list";

    }

    @PostMapping("/cadastrar")
    public String showFormulary(Model model){

        model.addAttribute("product", new Product());
        return "register";

    }

    @PostMapping("/cadastrar")
    public String register(Product product){

        repository.save(product);
        return "redirect:/";

    }

}
