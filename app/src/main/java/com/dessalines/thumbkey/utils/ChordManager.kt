package com.dessalines.thumbkey.utils

import android.util.Log

class ChordManager {
    private var state = 0
    private var curChord = 0

    var dict: Map<Int, String> = mapOf();

    fun setDict(newDict: KeyboardDefinitionChordDicts) {
        dict = newDict.alpha + newDict.shifted + newDict.numeric
    }

    fun keyDown(keyMask: Int) {
        state = state or keyMask
        curChord = curChord or keyMask
    }

    fun keyUp(keyMask: Int): String? {
        state = state and (-1 xor keyMask)

        if (state != 0) { // some keys are still held
            return null
        }

        // chord done
        val res = dict[curChord]
        curChord = 0
        return res
    }

    fun resetState() {
        state = 0
        curChord = 0
    }
}