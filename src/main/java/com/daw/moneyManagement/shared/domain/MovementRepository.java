package com.daw.moneyManagement.shared.domain;

import java.util.List;
import java.util.Optional;

public interface MovementRepository {

    Movement save(Movement movement);
    Optional<Movement> findById(Long id);
    List<Movement> findAll();
    void deleteById(Long id);
}
