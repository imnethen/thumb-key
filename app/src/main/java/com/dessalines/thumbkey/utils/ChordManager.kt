package com.dessalines.thumbkey.utils

class ChordManager {
    private var state = 0
    private var curChord = 0

    private val dict = mapOf(0 to "",
        0b1000_0000 to "i",
        0b0100_0000 to "n",
        0b0010_0000 to "s",
        0b0001_0000 to "r",

        0b0000_1000 to "e",
        0b0000_0100 to "t",
        0b0000_0010 to "o",
        0b0000_0001 to "a",

        0b1100_0000 to "y",
        0b0011_0000 to "b",
        0b0000_1100 to "h",
        0b0000_0011 to "l",

        0b1001_0000 to "g",
        0b0000_0110 to "u",
        0b0000_1001 to "d",
        0b0110_0000 to "p",

        0b0000_1010 to "c",
        0b0000_0101 to "q",
        0b1010_0000 to "f",
        0b0101_0000 to "z",

        0b0010_1000 to "v",
        0b0001_0100 to "x",
        0b1000_0010 to "k",
        0b0100_0001 to "j",

        0b0100_0010 to "_",
        0b1000_0001 to "w",
        0b0001_1000 to "m",
        0b0010_0100 to "/",

        0b0010_0001 to "'",
        0b0001_0010 to ";",
        0b1000_0100 to "?",
        0b0100_1000 to ",")

    // TODO: consider merging down and up into toggle
    //  that would b less repeating code but seems possible breakable mayb ??
    fun keyDown(key: Int) {
        assert((state and (1 shl key)) == 0)

        state = state or (1 shl key)
        curChord = curChord or (1 shl key)
    }

    fun keyUp(key: Int): String? {
        assert((state and (1 shl key)) != 0)

        state = state xor (1 shl key)

        if (state != 0) { // some keys are still held
            return null
        }

        // chord done
        val res = dict[curChord]
        curChord = 0
        return res
    }
}