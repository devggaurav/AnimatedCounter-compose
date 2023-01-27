@file:OptIn(ExperimentalAnimationApi::class)

package com.gc.counteranimation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle


//
// Created by Code For Android on 26/01/23.
// Copyright (c) 2023 CFA. All rights reserved.
//

@Composable
fun AnimatedCounter(
    count: Int,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.h1,
    increment: Boolean = true
) {

    var oldCount by remember {
        mutableStateOf(count)
    }


    SideEffect {
        oldCount = count
    }

    Row(modifier = modifier) {
        val countString = count.toString()
        val oldCountString = oldCount.toString()

        for (i in countString.indices) {

            var oldChar = oldCountString.getOrNull(i)
            var newChar = countString[i]

            var char = if (oldChar == newChar) {
                oldCountString[i]
            } else {
                countString[i]
            }
            if (increment) {
                AnimatedContent(targetState = char,
                    transitionSpec =
                    { slideInVertically { it } with slideOutVertically { -it } }
                ) { char ->
                    Text(text = char.toString(), style = style, softWrap = false)
                }
            }else{
                AnimatedContent(targetState = char,
                    transitionSpec =
                    { slideInVertically { -it } with slideOutVertically { it } }
                ) { char ->
                    Text(text = char.toString(), style = style, softWrap = false)
                }

            }

        }

    }


}