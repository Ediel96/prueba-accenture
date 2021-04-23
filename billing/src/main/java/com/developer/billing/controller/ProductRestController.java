package com.developer.billing.controller;

import com.developer.billing.models.entity.Product;
import com.developer.billing.models.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private IProductServices iProductServices;

    @GetMapping("/product")
    public List<Product> index(){
        return iProductServices.findAll();
    }


    @GetMapping("/product/{id}")
    public Product show(@PathVariable Long id){
        return iProductServices.findById(id);
    }

}
