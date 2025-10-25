package com.daw.moneyManagement.newMovement.infraestructure;

import com.daw.moneyManagement.shared.domain.TypeMovement;
import com.daw.moneyManagement.newMovement.application.NewMovementRequest;
import com.daw.moneyManagement.newMovement.domain.NewMovementUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class NewMovementController {

    private final NewMovementUseCase newMovementUseCase;

    public NewMovementController(NewMovementUseCase newMovementUseCase) {
        this.newMovementUseCase = newMovementUseCase;
    }

    @PostMapping("/movements/new")
    public String createMovement(
            @RequestParam String concept,
            @RequestParam BigDecimal amount,
            @RequestParam LocalDate date,
            @RequestParam TypeMovement type) {

        NewMovementRequest request = new NewMovementRequest(concept, amount, date, type);
        newMovementUseCase.execute(request);
        return "redirect:/";
    }
}