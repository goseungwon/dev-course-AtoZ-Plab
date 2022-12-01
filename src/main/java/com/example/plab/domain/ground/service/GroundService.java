package com.example.plab.domain.ground.service;

import com.example.plab.domain.ground.dto.GroundDto;
import com.example.plab.domain.ground.mapper.GroundMapper;
import com.example.plab.domain.ground.repository.GroundRepository;
import com.example.plab.entity.Ground;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroundService {

    private final GroundRepository groundRepository;
    private final GroundMapper groundMapper;


    public List<Ground> getGrounds() {
        return groundRepository.findAll();
    }

    public Ground getGroundById(Long groundId) {
        Optional<Ground> ground = groundRepository.findById(groundId);
        return ground.orElseThrow(() -> new NoSuchElementException("존재하지 않는 ground 입니다."));
    }

    public Ground createGround(GroundDto groundDto) {
        Ground ground = groundMapper.toGround(groundDto);
        return groundRepository.save(ground);
    }

    public Ground updateGround(Ground ground) {
        return groundRepository.save(ground);
    }

    public void deleteGround(Long groundId) {
        groundRepository.deleteById(groundId);
    }
}
