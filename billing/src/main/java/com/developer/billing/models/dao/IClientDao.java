package com.developer.billing.models.dao;

import com.developer.billing.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientDao extends JpaRepository<Client , Long> {
}
