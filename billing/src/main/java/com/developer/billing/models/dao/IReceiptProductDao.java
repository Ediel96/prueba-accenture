package com.developer.billing.models.dao;

import com.developer.billing.models.entity.ReceiptProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReceiptProductDao  extends JpaRepository<ReceiptProduct , Long> {
}
