package com.daw.moneyManagement.deleteMovement.infraestructure;

import com.daw.moneyManagement.deleteMovement.domain.DeleteMovementUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteMovementController {

    private final DeleteMovementUseCase deleteMovementUseCase;

    public DeleteMovementController(DeleteMovementUseCase deleteMovementUseCase) {
        this.deleteMovementUseCase = deleteMovementUseCase;
    }

    @PostMapping("/movements/delete")
    public String deleteMovement(@RequestParam Long id) {
        deleteMovementUseCase.execute(id);
        return "redirect:/";
    }
}