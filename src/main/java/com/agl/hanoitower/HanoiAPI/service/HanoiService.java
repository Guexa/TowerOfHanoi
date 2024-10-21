package com.agl.hanoitower.HanoiAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.agl.hanoitower.HanoiAPI.model.Hanoi;

@Service
public class HanoiService {
    
    public List<Hanoi> solveHanoi(int numDisks, String from, String to, String auxiliar) {
        List<Hanoi> moves = new ArrayList<>();
        moveDisks(numDisks, from, to, auxiliar, moves);
        return moves;
    }

    public int calculateMinMoves(int numDisks) {
        return (int) Math.pow(2, numDisks) - 1;
    }

    private void moveDisks(int numDisks, String from, String to, String auxiliar, List<Hanoi> moves) {
        if (numDisks == 1) {
            moves.add(new Hanoi(1, from, to));
            return;
        }
        moveDisks(numDisks - 1, from, auxiliar, to, moves);
        moves.add(new Hanoi(numDisks, from, to));
        moveDisks(numDisks - 1, auxiliar, to, from, moves);
    }
}
