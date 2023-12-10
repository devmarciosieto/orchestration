package br.com.mmmsieto.orchestrationservice.application.core.domain.enums;

public enum SaleEvent {

    CREATE_SALE,
    CREATED_SALE,
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
