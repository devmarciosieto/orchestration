package br.com.mmmsieto.saleservice.application.core.domain.enums;

public enum SaleEvent {

    CREATED_SALE,
    FINALIZED_SALE,
    CANCELED_SALE,
    CREATE_SALE,
    CANCEL_SALE,
    FINALIZE_SALE,
    PREPARE_INVENTORY,
    INVENTORY_PREPARED,
    INVENTORY_ERROR,
    EXECUTE_ROLLBACK,
    EXECUTE_PAYMENT,
    PAYMENT_EXECUTED,
    PAYMENT_FAILED

}
