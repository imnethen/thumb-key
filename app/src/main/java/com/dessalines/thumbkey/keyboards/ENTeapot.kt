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

val KB_EN_TEAPOT_MAIN =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC(1 shl 7, "r", size=LARGE),
                ),
                KeyItemC(
                    center = KeyC(1 shl 6, "t", size=LARGE),
                ),
                KeyItemC(
                    center = KeyC(1 shl 5, "e", size=LARGE),
                ),
                KeyItemC(
                    center = KeyC(1 shl 4, "a", size=LARGE),
                ),
            ),
            listOf(
                KeyItemC(
                    center = KeyC(1 shl 3, "n", size=LARGE),
                ),
                KeyItemC(
                    center = KeyC(1 shl 2, "o", size=LARGE),
                ),
                KeyItemC(
                    center = KeyC(1 shl 1, "s", size=LARGE),
                ),
                KeyItemC(
                    center = KeyC(1 shl 0, "i", size=LARGE),
                ),
            ),
            listOf(
                KeyItemC(
                    center = KeyC(1 shl 9),
                    widthMultiplier = 2,
                    backgroundColor = SURFACE_VARIANT
                ),
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

val KB_EN_TEAPOT_SHIFTED =
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
                KeyItemC(
                    center = KeyC(1 shl 9),
                    widthMultiplier = 2,
                    backgroundColor = SURFACE_VARIANT
                ),
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

val KB_EN_TEAPOT: KeyboardDefinition =
    KeyboardDefinition(
        title = "english teapot",
        modes =
            KeyboardDefinitionModes(
                main = KB_EN_TEAPOT_MAIN,
                shifted = KB_EN_TEAPOT_SHIFTED,
                numeric = NUMERIC_KEYBOARD,
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )
