package com.developer.billing.models.services;

import com.developer.billing.models.entity.ReceiptProduct;

import java.util.List;

public interface IReceiptProductServices {

    public List<ReceiptProduct> findAll();

    public ReceiptProduct findById(Long id);

    public ReceiptProduct save (ReceiptProduct receiptProduct);

    public  void delete (Long id);
}
