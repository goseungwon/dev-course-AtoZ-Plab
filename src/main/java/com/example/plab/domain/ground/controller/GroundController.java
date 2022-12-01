package com.example.plab.domain.ground.controller;

import com.example.plab.domain.ground.dto.GroundDto;
import com.example.plab.domain.ground.service.GroundService;
import com.example.plab.entity.Ground;
import com.example.plab.util.response.CommonResponse;
import com.example.plab.util.response.ResponseCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class GroundController {

    private final GroundService groundService;

    @GetMapping("/api/ground")
    public CommonResponse<?> showGrounds() {
        List<Ground> grounds = groundService.getGrounds();
        return new CommonResponse<>(grounds);
    }

    @GetMapping("/api/ground/{groundId}")
    public CommonResponse<?> showGroundInfo(@PathVariable Long groundId) {
         Ground ground = groundService.getGroundById(groundId);
         return new CommonResponse<>(ground);
    }

    @PostMapping("/api/ground/new")
    public CommonResponse<?> createGround(@RequestBody @Valid GroundDto groundDto) {
        Ground ground = groundService.createGround(groundDto);
        return new CommonResponse<>(ground);
    }

    @PostMapping("/api/ground/{groundId}/update")
    public CommonResponse<?> updateGround(@PathVariable Long groundId, @RequestBody @Valid Ground ground) {
        Ground updateGround = groundService.updateGround(ground);
        return new CommonResponse<>(updateGround);
    }

    @PostMapping("/api/ground/{groundId}/delete")
    public CommonResponse<?> deleteGround(@PathVariable Long groundId) {
        groundService.deleteGround(groundId);
        return new CommonResponse<>("Ground 삭제 완료.");
    }

    @ExceptionHandler(NoSuchElementException.class)
    public CommonResponse<?> handleNoSuchElementException(NoSuchElementException exception) {
        return new CommonResponse<>(ResponseCode.NOT_FOUND_GROUND);
    }

}
