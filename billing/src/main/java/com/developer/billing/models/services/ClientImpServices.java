package com.developer.billing.models.services;

import com.developer.billing.models.dao.IClientDao;
import com.developer.billing.models.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientImpServices implements IClientServices {
    @Autowired
    private IClientDao iClientDao;


    @Override
    public List<Client> findAll() {
        return (List<Client>) iClientDao.findAll();
    }

    @Override
    public Client findById(Long id) {
        return iClientDao.findById(id).orElse(null);
    }

    @Override
    public Client save(Client client) {
        return iClientDao.save(client);
    }

    @Override
    public void delete(Long id) {
        iClientDao.deleteById(id);
    }
}
