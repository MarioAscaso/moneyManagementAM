package com.daw.moneyManagement.deleteMovement.domain;

import com.daw.moneyManagement.shared.domain.MovementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteMovementUseCase {

    private final MovementRepository movementRepository;

    public DeleteMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Transactional
    public void execute(Long id) {
        movementRepository.deleteById(id);
    }
}