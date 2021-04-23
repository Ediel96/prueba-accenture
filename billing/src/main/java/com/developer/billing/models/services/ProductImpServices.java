package com.developer.billing.models.services;

import com.developer.billing.models.dao.IProductDao;
import com.developer.billing.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpServices  implements  IProductServices{

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public void delete(Long id) {
        productDao.deleteById(id);
    }
}
