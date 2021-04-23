package com.developer.billing.controller;

import com.developer.billing.models.entity.Client;
import com.developer.billing.models.services.IClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ClientRestController {

    @Autowired
    private IClientServices iClientServices;

    @GetMapping("/client")
    public List<Client> index(){
        return iClientServices.findAll();
    }
}
