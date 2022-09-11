package com.debduttapanda.swipeablemodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.debduttapanda.swipeablemodifier.ui.theme.SwipeableModifierTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeableModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(){
                        SwipeableSample()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeableSample() {
    val squareSize = 48.dp

    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { 96.dp.toPx() }
    val anchors = mapOf(
        0f to 0,
        sizePx to 1,
        sizePx*2 to 2,
        sizePx*3 to 3,
    ) // Maps anchor points (in px) to states

    Box(){
        Row(){
            Box(
                Modifier
                    .size(squareSize)
                    .background(Color.White)
            )
            Box(
                Modifier
                    .size(squareSize)
                    .background(Color.Cyan)
            )
            Box(
                Modifier
                    .size(squareSize)
                    .background(Color.White)
            )
            Box(
                Modifier
                    .size(squareSize)
                    .background(Color.Cyan)
            )
            Box(
                Modifier
                    .size(squareSize)
                    .background(Color.White)
            )
            Box(
                Modifier
                    .size(squareSize)
                    .background(Color.Cyan)
            )
            Box(
                Modifier
                    .size(squareSize)
                    .background(Color.White)
            )
            Box(
                Modifier
                    .size(squareSize)
                    .background(Color.Cyan)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.3f) },
                    orientation = Orientation.Horizontal
                )
        ) {
            Box(
                Modifier
                    .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                    .size(squareSize)
                    .background(Color.DarkGray)
            )
        }
    }


}