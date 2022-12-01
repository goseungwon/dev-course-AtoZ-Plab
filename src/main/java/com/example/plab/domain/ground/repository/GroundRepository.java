package com.example.plab.domain.ground.repository;

import com.example.plab.entity.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GroundRepository extends JpaRepository<Ground, Long> {
}
