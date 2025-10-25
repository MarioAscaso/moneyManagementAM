package com.daw.moneyManagement.listMovements.infraestructure;

import com.daw.moneyManagement.shared.domain.Movement;
import com.daw.moneyManagement.shared.domain.TypeMovement;
import com.daw.moneyManagement.listMovements.domain.ListMovementsUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListMovementsController {

    private final ListMovementsUseCase listMovementsUseCase;

    public ListMovementsController(ListMovementsUseCase listMovementsUseCase) {
        this.listMovementsUseCase = listMovementsUseCase;
    }

    @GetMapping("/")
    public String showMainPage(Model model) {

        List<Movement> movements = listMovementsUseCase.execute();
        model.addAttribute("movements", movements);
        model.addAttribute("MovementType", TypeMovement.class);
        return "index";
    }
}