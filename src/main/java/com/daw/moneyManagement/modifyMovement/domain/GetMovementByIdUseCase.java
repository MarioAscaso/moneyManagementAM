package com.daw.moneyManagement.modifyMovement.domain;

import com.daw.moneyManagement.shared.domain.Movement;
import com.daw.moneyManagement.shared.domain.MovementRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetMovementByIdUseCase {

    private final MovementRepository movementRepository;

    public GetMovementByIdUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Optional<Movement> execute(Long id) {
        return movementRepository.findById(id);
    }
}