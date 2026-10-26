package cat.montilivi.primerprojecte

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.montilivi.primerprojecte.ui.theme.PrimerProjecteTheme

@Composable
fun CampAmbEtiquetaAmbEstat(
    etiqueta: String,
    valor: String,
    onCanvi: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = etiqueta, color = Color.Green)
        TextField(
            value = valor,
            onValueChange = onCanvi,
            singleLine = true
        )
    }
}

@Composable
fun PantallaContacte(modifier: Modifier = Modifier) {
    var nom by rememberSaveable { mutableStateOf("") }
    var telefon by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
            .padding(32.dp)
    ) {
        CampAmbEtiquetaAmbEstat(
            etiqueta = "Nom",
            valor = nom,
            onCanvi = { nom = it }
        )
        CampAmbEtiquetaAmbEstat(
            etiqueta = "Telèfon",
            valor = telefon,
            onCanvi = { telefon = it }
        )
        Button(
            onClick = {
                nom = ""
                telefon = ""
            },
        ) {
            Text("BUIDA")
        }
    }
}

@Preview
@Composable
fun CampEtiquetaPreview() {
    PrimerProjecteTheme {
        PantallaContacte()
    }
}
