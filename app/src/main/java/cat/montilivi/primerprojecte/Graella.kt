package cat.montilivi.primerprojecte

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.montilivi.primerprojecte.ui.theme.PrimerProjecteTheme

@Composable
fun Graella(){
    Row(
        modifier = Modifier
            .background(
                color =
                    MaterialTheme.colorScheme.error)
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .background(color=Color(0xffeddf1e))
            .padding(40.dp)
            .weight(1F)){
        }
        Column(modifier = Modifier
            .fillMaxHeight()
            .background(color=Color(0xffedcf8e))
            .padding(4.dp)
            .weight(1F)){
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PantallaGraellaPreview(){
    PrimerProjecteTheme{
        Graella()
    }
}