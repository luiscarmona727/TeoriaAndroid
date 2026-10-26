package cat.montilivi.primerprojecte

import android.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.montilivi.primerprojecte.ui.theme.PrimerProjecteTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimerProjecteTheme {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Formulari(){
    var nom = remember() {mutableStateOf("")}
    Column(){
        Text(stringResource(cat.montilivi.primerprojecte.R.string.nom))
        TextField(
            value = nom.value,
            onValueChange = { text -> nom.value = text }
            )}
    }

@Preview(showBackground = true)
@Composable
fun ExempleBox(){
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .background(Color.Red),
        content = {
            Caixeta(modifier = Modifier
                .background(Color.Blue)
                .align(Alignment.TopStart))
            Caixeta(modifier = Modifier
                .background(Color.Red)
                .align(Alignment.TopCenter))
            Caixeta(modifier = Modifier
                .background(Color.Green)
                .align(Alignment.TopEnd))
            Caixeta(modifier = Modifier
                .background(Color.DarkGray)
                .align(Alignment.CenterStart))
            Caixeta(modifier = Modifier
                .background(Color.White)
                .align(Alignment.Center))
            Caixeta(modifier = Modifier
                .background(Color.Magenta)
                .align(Alignment.CenterEnd))
            Caixeta(modifier = Modifier
                .background(Color.LightGray)
                .align(Alignment.BottomStart))
            Caixeta(modifier = Modifier
                .background(Color.Yellow)
                .align(Alignment.BottomCenter))
            Caixeta(modifier = Modifier
                .background(Color.Cyan)
                .align(Alignment.BottomEnd))
        }
    )
}
@Composable
fun Caixeta(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(100.dp)
            .height(100.dp),
        content = { Text("Hola", modifier = Modifier.align(Alignment.Center)) }
    )
}
