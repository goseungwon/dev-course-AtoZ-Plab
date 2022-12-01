package com.example.plab.domain.ground.mapper;

import com.example.plab.domain.ground.dto.GroundDto;
import com.example.plab.entity.Ground;
import org.springframework.stereotype.Component;

@Component
public class GroundMapper {
    public Ground toGround(GroundDto groundDto) {
        return Ground
                .builder()
                .groundName(groundDto.getGroundName())
                .groundAddress(groundDto.getGroundAddress())
                .build();
    }
}
