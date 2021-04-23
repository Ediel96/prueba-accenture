package com.developer.billing.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "receipt_product")
public class ReceiptProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;


    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name="iva_product")
    private double ivaProduct;

    @Column(name="send_value")
    private double sendValue;

    @Column(name="product_total")
    private double  productTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public double getIvaProduct() {
        return ivaProduct;
    }

    public void setIvaProduct(double ivaProduct) {
        this.ivaProduct = ivaProduct;
    }

    public double getSendValue() {
        return sendValue;
    }

    public void setSendValue(double sendValue) {
        this.sendValue = sendValue;
    }

    public double getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(double productTotal) {
        this.productTotal = productTotal;
    }
}
