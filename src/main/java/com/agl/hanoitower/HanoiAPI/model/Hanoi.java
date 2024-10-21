package com.agl.hanoitower.HanoiAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hanoi {

    private int disk;
    private String from;
    private String to;

    @Override
    public String toString() {
        return "Disk: " + disk + " from: " + from + " to: " + to;
    }
}
