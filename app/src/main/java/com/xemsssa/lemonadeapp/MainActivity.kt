package com.xemsssa.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemsssa.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                LemonTree()
            }
        }
    }
}

@Composable
private fun LemonTree() {

    var screen by remember { mutableStateOf(1) }
    var squize by remember { mutableStateOf(0) }
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {

        when (screen) {
            1 -> {
//                ShowLemonTreeAndText(screenNumber = 1)
                ShowLemonTreeAndText(
                    text = R.string.tap_lemon_tree,
                    image = R.drawable.lemon_tree,
                    descr = R.string.tap_lemon_tree,
                    onClick = {
                        screen = 2
                        squize = (2..4).random()
                    }
                )
            }

            2 -> {
                ShowLemonTreeAndText(
                    text = R.string.tapping,
                    image = R.drawable.lemon_squeeze,
                    descr = R.string.lemon,
                    onClick = {
                        squize--
                        if (squize == 0){
                            screen = 3
                        }
                    }
                )
            }

            3 -> {
                ShowLemonTreeAndText(
                    text = R.string.drink,
                    image = R.drawable.lemon_drink,
                    descr = R.string.glass_of_lemonade,
                    onClick = {
                        screen = 4
                    }
                )
            }

            4 -> {
                ShowLemonTreeAndText(
                    text = R.string.empty,
                    image = R.drawable.lemon_restart,
                    descr = R.string.empty_glasee,
                    onClick = {
                        screen = 1
                    }
                )
            }
        }
    }
}

@Composable
private fun ShowLemonTreeAndText(descr: Int, image: Int, text: Int, onClick: () -> Unit) {
    Column (
        modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
//            onClick = {  }
            onClick = onClick
        ) {
            Image(
//                painter = painterResource(R.drawable.lemon_squeeze),
                painter = painterResource(image),
                contentDescription = text.toString(),
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
//            text = stringResource(R.string.tapping),
            text = stringResource(text),
            fontSize = 18.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun LemonTreePreview() {
    LemonTree()
}
