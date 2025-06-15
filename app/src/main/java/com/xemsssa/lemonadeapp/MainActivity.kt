package com.xemsssa.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xemsssa.lemonadeapp.ui.theme.LemonadeAppTheme
import java.sql.Wrapper

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
fun LemonTree() {
    Surface (
        color = MaterialTheme.colorScheme.background
    ){
        Column (
            modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.lemon_tree),
                contentDescription = null,
//                modifier = Modifier.clickable (
//                    onClick = click
//                ) {
//                }
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = stringResource(R.string.tap_lemon_tree),
                fontSize = 18.sp
            )
        }
    }

}

fun click() {

}

@Preview(showBackground = true)
@Composable
private fun LemonTreePreview() {
    LemonTree()
}
