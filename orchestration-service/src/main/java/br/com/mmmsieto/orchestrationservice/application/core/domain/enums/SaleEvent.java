package br.com.mmmsieto.orchestrationservice.application.core.domain.enums;

public enum SaleEvent {

    CANCEL_SALE,
    FINALIZE_SALE,
    PREPARE_INVENTORY,
    EXECUTE_ROLLBACK,
    EXECUTE_PAYMENT,
    CREATED_SALE,
    INVENTORY_PREPARED,
    INVENTORY_ERROR,
    PAYMENT_EXECUTED,
    PAYMENT_FAILED;

}
