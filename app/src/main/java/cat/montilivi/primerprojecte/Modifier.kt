package cat.montilivi.primerprojecte
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun OrdreDelModifier(){
    Text(
        text="Això és un text",
        style = MaterialTheme.typography.headlineLarge,
        color=MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .padding(30.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp)
    )
    Text(
        text="Això és un altre text",
        style = MaterialTheme.typography.headlineLarge,
        color=MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .padding(top=150.dp, start = 30.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp)
    )
}