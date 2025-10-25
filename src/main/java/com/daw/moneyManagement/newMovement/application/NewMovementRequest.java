package com.daw.moneyManagement.newMovement.application;

import com.daw.moneyManagement.shared.domain.TypeMovement;
import java.math.BigDecimal;
import java.time.LocalDate;

public record NewMovementRequest(
        String concept,
        BigDecimal amount,
        LocalDate date,
        TypeMovement type
) {
}