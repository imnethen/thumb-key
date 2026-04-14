@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardReturn
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
import androidx.compose.material.icons.outlined.Copyright
import androidx.compose.material.icons.outlined.KeyboardCapslock
import androidx.compose.material.icons.outlined.Numbers
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

val KB_EN_TEAPOT_SWIPESPACE_MAIN =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC(1 shl 7, "r", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(1 shl 6, "t", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(1 shl 5, "e", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(1 shl 4, "a", size=LARGE)
                ),
            ),
            listOf(
                KeyItemC(
                    center = KeyC(1 shl 3, "n", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(1 shl 2, "o", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(1 shl 1, "s", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(1 shl 0, "i", size=LARGE)
                ),
            ),
            listOf(
                SPACEBAR_DOUBLE_KEY_ITEM,
                BACKSPACE_KEY_ITEM,
                KeyItemC(
                    swipeType = FOUR_WAY_CROSS,
                    backgroundColor = SURFACE_VARIANT,
                    center = KeyC(
                        display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                        action = ToggleShiftMode(true),
                        color = SECONDARY,
                        size = LARGE,
                    ),
                    bottom = KeyC("\n", "\\n", size = SMALL, color = MUTED),
                    right = KeyC(
                        display = KeyDisplay.IconDisplay(Icons.AutoMirrored.Outlined.KeyboardReturn),
                        action = IMECompleteAction,
                        size = SMALL,
                        color = MUTED,
                    ),
                    top = TOGGLE_CAPS_KEYC,
                    left = KeyC(
                        display = KeyDisplay.IconDisplay(Icons.Outlined.Numbers),
                        action = ToggleNumericMode(true),
                        size = SMALL,
                        color = MUTED,
                    ),
                ),
            )
        )
    )

val KB_EN_TEAPOT_SWIPESPACE_SHIFTED =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC((1 shl 8) or (1 shl 7), "R", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC((1 shl 8) or (1 shl 6), "T", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC((1 shl 8) or (1 shl 5), "E", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC((1 shl 8) or (1 shl 4), "A", size=LARGE)
                ),
            ),
            listOf(
                KeyItemC(
                    center = KeyC((1 shl 8) or (1 shl 3), "N", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC((1 shl 8) or (1 shl 2), "O", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC((1 shl 8) or (1 shl 1), "S", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC((1 shl 8) or (1 shl 0), "I", size=LARGE)
                ),
            ),
            listOf(
                SPACEBAR_DOUBLE_KEY_ITEM,
                BACKSPACE_KEY_ITEM,
                KeyItemC(
                    swipeType = FOUR_WAY_CROSS,
                    backgroundColor = SURFACE_VARIANT,
                    center = KeyC(
                        display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropDown),
                        action = ToggleShiftMode(false),
                        color = SECONDARY,
                        size = LARGE,
                    ),
                    bottom = KeyC("\n", "\\n", size = SMALL, color = MUTED),
                    right = KeyC(
                        display = KeyDisplay.IconDisplay(Icons.AutoMirrored.Outlined.KeyboardReturn),
                        action = IMECompleteAction,
                        size = SMALL,
                        color = MUTED,
                    ),
                    top = TOGGLE_CAPS_KEYC,
                    left = KeyC(
                        display = KeyDisplay.IconDisplay(Icons.Outlined.Numbers),
                        action = ToggleNumericMode(true),
                        size = SMALL,
                        color = MUTED,
                    ),
                ),
            )
        )
    )

private val dictAlpha = mapOf(
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
)

private val dictShifted = mapOf(
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
)

private val dictNumeric = mapOf(
    0b100_1000_0000 to "0",
    0b100_0100_0000 to "1",
    0b100_0010_0000 to "2",
    0b100_0001_0000 to "(",

    0b100_0000_1000 to "3",
    0b100_0000_0100 to "4",
    0b100_0000_0010 to "5",
    0b100_0000_0001 to ")",

    0b100_1100_0000 to "6",
    0b100_0110_0000 to "7",
    0b100_0011_0000 to "+",

    0b100_0000_1100 to "8",
    0b100_0000_0110 to "9",
    0b100_0000_0011 to "=",

    0b100_1010_0000 to "&",
    0b100_0101_0000 to "~",
    0b100_0000_1010 to "-",
    0b100_0000_0101 to "_",

    0b100_0010_1000 to "<",
    0b100_0001_0100 to ">",

    0b100_0100_1000 to "/",
    0b100_0010_0100 to "%",
    0b100_0001_0010 to "`",

    0b100_1000_1000 to "|",
    0b100_0100_0100 to "{",
    0b100_0010_0010 to "}",
    0b100_0001_0001 to ";",

    0b100_1000_0100 to "\\",
    0b100_0100_0010 to "[",
    0b100_0010_0001 to "]",

    0b100_1001_0000 to "^",
    0b100_0000_1001 to "*",

    0b100_0001_1000 to "#",
    0b100_1000_0001 to "$",
)

val KB_EN_TEAPOT_SWIPESPACE: KeyboardDefinition =
    KeyboardDefinition(
        title = "english teapot swipespace",
        modes =
            KeyboardDefinitionModes(
                main = KB_EN_TEAPOT_SWIPESPACE_MAIN,
                shifted = KB_EN_TEAPOT_SWIPESPACE_SHIFTED,
                numeric = KB_EN_TEAPOT_NUMERIC,
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
        chordDicts =
            KeyboardDefinitionChordDicts(
                alpha = dictAlpha,
                shifted = dictShifted,
                numeric = dictNumeric,
            ),
    )
