package com.dessalines.thumbkey.utils

class ChordManager {
    private var state = 0
    private var curChord = 0

    private val dict = mapOf(0 to "", 1 to "a", 2 to "b", 3 to "c") // TODO

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