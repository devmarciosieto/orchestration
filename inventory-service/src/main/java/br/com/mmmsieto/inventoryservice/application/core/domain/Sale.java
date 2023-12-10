package br.com.mmmsieto.inventoryservice.application.core.domain;

import br.com.mmmsieto.inventoryservice.application.core.domain.enums.SaleStatus;

import java.math.BigDecimal;

public class Sale {

    public Sale() {
    }

    public Sale(Long productId, Long userId, BigDecimal price, SaleStatus status, Integer quantity) {
        this.productId = productId;
        this.userId = userId;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
    }

    private Long id;

    private Long productId;

    private Long userId;

    private BigDecimal price;

    private SaleStatus status;

    private Integer quantity;

    public Sale(Long productId, Long userId, BigDecimal price, Integer quantity) {
        this.productId = productId;
        this.userId = userId;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
