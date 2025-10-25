package com.daw.moneyManagement.newMovement.domain;

import com.daw.moneyManagement.shared.domain.Movement;
import com.daw.moneyManagement.shared.domain.MovementRepository;
import com.daw.moneyManagement.newMovement.application.NewMovementRequest;
import org.springframework.stereotype.Service;

@Service
public class NewMovementUseCase {

    private final MovementRepository movementRepository;

    public NewMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public void execute(NewMovementRequest request) {
        Movement movement = new Movement(
                request.concept(),
                request.amount(),
                request.date(),
                request.type()
        );

        movementRepository.save(movement);
    }
}
