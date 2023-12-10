package br.com.mmmsieto.saleservice.application.core.domain.enums;

import java.util.Arrays;

public enum SaleStatus {
    PENDING(1),
    FINISHED(2),
    CANCELLED(3);

    private final int statusId;

    SaleStatus(int statusId) {
        this.statusId = statusId;
    }

    public int getStatusId() {
        return statusId;
    }

    public static SaleStatus fromStatusId(Integer statusId) {
        if (statusId == null) return null;

        return Arrays.stream(SaleStatus.values())
                .filter(saleStatus -> statusId.equals(saleStatus.getStatusId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid status id: " + statusId));
    }

}
