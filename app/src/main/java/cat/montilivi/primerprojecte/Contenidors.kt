package cat.montilivi.primerprojecte
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.montilivi.primerprojecte.ui.theme.PrimerProjecteTheme
@Composable
fun PantallaReproductor() {
    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Image(
            painter= painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Logo d'android",
            contentScale = ContentScale.Fit,
            modifier= Modifier
                .padding(32.dp)
                .fillMaxWidth()
                .height(550.dp)
                .background(MaterialTheme.colorScheme.onSecondaryContainer)
                .weight(1F)

        )
        BarraDeReproduccio()
    }
}

@Composable
fun BarraDeReproduccio() {
    Row(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(4.dp),
        verticalAlignment= Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ){
        Text(
            text="Thriller",
            color= MaterialTheme.colorScheme.onTertiary,
            style= MaterialTheme.typography.titleLarge,
            modifier= Modifier
                .padding(start=8.dp)
                .weight(1F)
        )
        Button(
            onClick={},
            modifier = Modifier
                .weight(2F)
        ){
            Text("|>",
                color= MaterialTheme.colorScheme.onPrimary,
                style= MaterialTheme.typography.titleLarge
            )
        }
        Button(
            onClick={},
            modifier = Modifier
                .weight(1F)
        ){
            Text("||>",
                color= MaterialTheme.colorScheme.onPrimary,
                style= MaterialTheme.typography.titleLarge,)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PantallaReproductorPreview(){
    PrimerProjecteTheme{
        PantallaReproductor()
    }
}

