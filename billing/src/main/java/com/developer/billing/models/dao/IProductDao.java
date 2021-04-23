package com.developer.billing.models.dao;

import com.developer.billing.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDao extends JpaRepository<Product , Long> {
}
