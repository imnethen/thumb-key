package com.dessalines.thumbkey.utils

import android.util.Log

class ChordManager {
    private var state = 0
    private var curChord = 0

    private val dictAlpha = mapOf(
        0b10_0000_0000 to " ",

        0b1000_0000 to "r",
        0b0100_0000 to "t",
        0b0010_0000 to "e",
        0b0001_0000 to "a",

        0b0000_1000 to "n",
        0b0000_0100 to "o",
        0b0000_0010 to "s",
        0b0000_0001 to "i",

        0b1100_0000 to "v",
        0b0110_0000 to "m",
        0b0011_0000 to "h",

        0b0000_1100 to "y",
        0b0000_0110 to "u",
        0b0000_0011 to "p",

        0b1010_0000 to "b",
        0b0101_0000 to "j",
        0b0000_1010 to "g",
        0b0000_0101 to "f",

        0b0010_1000 to "w",
        0b0001_0100 to "k",

        0b0100_1000 to "d",
        0b0010_0100 to "l",
        0b0001_0010 to "c",

        0b1000_1000 to ":3",
        0b0100_0100 to "q",
        0b0010_0010 to "x",
        0b0001_0001 to "z",

        0b1000_0100 to "z",
        0b0100_0010 to "q",
        0b0010_0001 to "x",

        0b10_1000_0000 to "@",
        0b10_0100_0000 to ".",
        0b10_0010_0000 to "?",
        0b10_0001_0000 to "\"",

        0b10_0000_1000 to ":",
        0b10_0000_0100 to ",",
        0b10_0000_0010 to "'",
        0b10_0000_0001 to "!",
    )

    private val dictShifted = mapOf(
        0b11_0000_0000 to " ",

        0b1_1000_0000 to "R",
        0b1_0100_0000 to "T",
        0b1_0010_0000 to "E",
        0b1_0001_0000 to "A",

        0b1_0000_1000 to "N",
        0b1_0000_0100 to "O",
        0b1_0000_0010 to "S",
        0b1_0000_0001 to "I",

        0b1_1100_0000 to "V",
        0b1_0110_0000 to "M",
        0b1_0011_0000 to "H",

        0b1_0000_1100 to "Y",
        0b1_0000_0110 to "U",
        0b1_0000_0011 to "P",

        0b1_1010_0000 to "B",
        0b1_0101_0000 to "J",
        0b1_0000_1010 to "G",
        0b1_0000_0101 to "F",

        0b1_0010_1000 to "W",
        0b1_0001_0100 to "K",

        0b1_0100_1000 to "D",
        0b1_0010_0100 to "L",
        0b1_0001_0010 to "C",

        0b1_1000_1000 to ":3",
        0b1_0100_0100 to "Q",
        0b1_0010_0010 to "X",
        0b1_0001_0001 to "Z",

        0b1_1000_0100 to "Z",
        0b1_0100_0010 to "Q",
        0b1_0010_0001 to "X",

        0b11_1000_0000 to "@",
        0b11_0100_0000 to ".",
        0b11_0010_0000 to "?",
        0b11_0001_0000 to "\"",

        0b11_0000_1000 to ":",
        0b11_0000_0100 to ",",
        0b11_0000_0010 to "'",
        0b11_0000_0001 to "!",
    )

    private val dict = dictAlpha + dictShifted
    
    fun keyDown(keyMask: Int) {
        state = state or keyMask
        curChord = curChord or keyMask

        Log.i("state", state.toString())
    }

    fun keyUp(keyMask: Int): String? {
        state = state and (-1 xor keyMask)

        Log.i("state", state.toString())
        if (state != 0) { // some keys are still held
            return null
        }

        Log.i("curChord", curChord.toString())

        // chord done
        val res = dict[curChord]
        curChord = 0
        return res
    }
}