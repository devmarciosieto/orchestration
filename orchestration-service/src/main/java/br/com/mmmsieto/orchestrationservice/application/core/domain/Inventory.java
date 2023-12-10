package br.com.mmmsieto.orchestrationservice.application.core.domain;

public class Inventory {

    private Long id;

    private Long productId;

    private Integer quantity;

    public Inventory() {
    }

    public Inventory(Long id, Long productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void debitQuantity(Integer quantity) {
        this.quantity -= quantity;
    }

    public void creditQuantity(Integer quantity) {
        this.quantity += quantity;
    }

}
