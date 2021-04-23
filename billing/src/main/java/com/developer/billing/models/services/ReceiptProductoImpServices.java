package com.developer.billing.models.services;

import com.developer.billing.models.dao.IReceiptProductDao;
import com.developer.billing.models.entity.ReceiptProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptProductoImpServices  implements IReceiptProductServices{

    @Autowired
    private IReceiptProductDao iReceiptProductDao;

    @Override
    public List<ReceiptProduct> findAll() {
        return (List<ReceiptProduct>) iReceiptProductDao.findAll();
    }

    @Override
    public ReceiptProduct findById(Long id) {
        return iReceiptProductDao.findById(id).orElse(null);
    }

    @Override
    public ReceiptProduct save(ReceiptProduct receiptProduct) {
        return iReceiptProductDao.save(receiptProduct);
    }

    @Override
    public void delete(Long id) {
        iReceiptProductDao.deleteById(id);
    }
}
