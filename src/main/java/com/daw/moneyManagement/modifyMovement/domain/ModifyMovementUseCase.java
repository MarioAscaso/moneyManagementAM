package com.daw.moneyManagement.modifyMovement.domain;

import com.daw.moneyManagement.shared.domain.Movement;
import com.daw.moneyManagement.shared.domain.MovementRepository;
import com.daw.moneyManagement.shared.domain.TypeMovement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ModifyMovementUseCase {

    private final MovementRepository movementRepository;

    public ModifyMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Transactional
    public void execute(Long id, String concept, BigDecimal amount, LocalDate date, TypeMovement type) {
        Optional<Movement> optionalMovement = movementRepository.findById(id);

        if (optionalMovement.isPresent()) {
            Movement movement = optionalMovement.get();
            movement.setConcept(concept);
            movement.setAmount(amount);
            movement.setDate(date);
            movement.setType(type);
            movementRepository.save(movement);
        } else {
            throw new RuntimeException("Movimiento no encontrado con ID: " + id);
        }
    }
}