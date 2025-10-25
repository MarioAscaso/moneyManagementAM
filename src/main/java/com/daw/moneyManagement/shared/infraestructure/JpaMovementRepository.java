package com.daw.moneyManagement.shared.infraestructure;

import com.daw.moneyManagement.shared.domain.Movement;
import com.daw.moneyManagement.shared.domain.MovementRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovementRepository extends JpaRepository<Movement, Long>, MovementRepository {
}
