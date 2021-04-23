package com.developer.billing.models.services;

import com.developer.billing.models.entity.Client;

import java.util.List;

public interface IClientServices {

    public List<Client> findAll();

    public Client findById(Long id);

    public Client save (Client client);

    public  void delete (Long id);

}
