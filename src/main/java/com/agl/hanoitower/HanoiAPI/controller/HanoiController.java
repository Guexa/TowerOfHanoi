package com.agl.hanoitower.HanoiAPI.controller;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import com.agl.hanoitower.HanoiAPI.service.HanoiService;
import com.agl.hanoitower.HanoiAPI.model.Hanoi;

@RestController
@RequestMapping("/hanoi")
public class HanoiController {

    private HanoiService hanoiService;

    public HanoiController(HanoiService hanoiService) {
        this.hanoiService = hanoiService;
    }

    @ApiOperation(value = "Solves the Tower of Hanoi by giving the number of disks") 
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "API response successfully generated"),
        @ApiResponse(code = 400, message = "Invalid number of disks"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/solve-tower")
    public ResponseEntity<List<Hanoi>> solveHanoi(@RequestParam int numDisks) {
        if (numDisks <= 0) {
            return ResponseEntity.badRequest().build();
        }
        List<Hanoi> moves = hanoiService.solveHanoi(numDisks, "A", "C", "B");
        return ResponseEntity.ok(moves);
    }

    @ApiOperation(value = "Count the number of moves to solve the Tower of Hanoi by giving the number of disks")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "API response successfully generated"),
        @ApiResponse(code = 400, message = "Invalid number of disks"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping("/calculate-moves")
    public ResponseEntity<Integer> calculateMoves(@RequestParam int numDisks) {
        if (numDisks <= 0) {
            return ResponseEntity.badRequest().build();
        }
        int minMoves = hanoiService.calculateMinMoves(numDisks);
        return ResponseEntity.ok(minMoves);
    }
}