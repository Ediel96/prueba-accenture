package com.developer.billing.models.services;


import com.developer.billing.models.entity.Product;

import java.util.List;

public interface IProductServices {

    public List<Product> findAll();

    public  Product findById(Long id);

    public Product save (Product product);

    public void  delete (Long id);
}
