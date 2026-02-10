@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
import androidx.compose.material.icons.outlined.Copyright
import androidx.compose.material.icons.outlined.KeyboardCapslock
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

val KB_EN_CHORD_MAIN =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC(7, "r", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(6, "t", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(5, "e", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(4, "a", size=LARGE)
                ),
            ),
            listOf(
                KeyItemC(
                    center = KeyC(3, "n", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(2, "o", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(1, "s", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(0, "i", size=LARGE)
                ),
            ),
            listOf(
                SPACEBAR_DOUBLE_KEY_ITEM,
                BACKSPACE_KEY_ITEM,
                RETURN_KEY_ITEM,
            )
        )
    )

val KB_EN_CHORD_SHIFTED =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC(0, "i", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(1, "n", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(2, "s", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(3, "r", size=LARGE)
                ),
            ),
            listOf(
                KeyItemC(
                    center = KeyC(4, "e", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(5, "t", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(6, "o", size=LARGE)
                ),
                KeyItemC(
                    center = KeyC(7, "a", size=LARGE)
                ),
            ),
            listOf(
                SPACEBAR_DOUBLE_KEY_ITEM,
                BACKSPACE_KEY_ITEM,
                RETURN_KEY_ITEM
            )
        )
    )

val KB_EN_CHORD: KeyboardDefinition =
    KeyboardDefinition(
        title = "english chord",
        modes =
            KeyboardDefinitionModes(
                main = KB_EN_CHORD_MAIN,
                shifted = KB_EN_CHORD_SHIFTED,
                numeric = NUMERIC_KEYBOARD,
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )
