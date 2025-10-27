package com.daw.moneyManagement.modifyMovement.infraestructure;

import com.daw.moneyManagement.shared.domain.Movement;
import com.daw.moneyManagement.shared.domain.TypeMovement;
import com.daw.moneyManagement.modifyMovement.domain.GetMovementByIdUseCase;
import com.daw.moneyManagement.modifyMovement.domain.ModifyMovementUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class ModifyMovementController {

    private final GetMovementByIdUseCase getMovementByIdUseCase;
    private final ModifyMovementUseCase modifyMovementUseCase;

    public ModifyMovementController(GetMovementByIdUseCase getMovementByIdUseCase, ModifyMovementUseCase modifyMovementUseCase) {
        this.getMovementByIdUseCase = getMovementByIdUseCase;
        this.modifyMovementUseCase = modifyMovementUseCase;
    }

    @GetMapping("/movements/modify/{id}")
    public String showModifyForm(@PathVariable Long id, Model model) {
        Optional<Movement> optionalMovement = getMovementByIdUseCase.execute(id);

        if (optionalMovement.isPresent()) {
            model.addAttribute("movement", optionalMovement.get());
            return "modify-movement";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/movements/save")
    public String saveModifiedMovement(
            @RequestParam Long id,
            @RequestParam String concept,
            @RequestParam BigDecimal amount,
            @RequestParam LocalDate date,
            @RequestParam TypeMovement type) {

        modifyMovementUseCase.execute(id, concept, amount, date, type);

        return "redirect:/";
    }
}