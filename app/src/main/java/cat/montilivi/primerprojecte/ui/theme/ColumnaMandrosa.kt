package cat.montilivi.primerprojecte.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.montilivi.primerprojecte.DADES.planetes
import cat.montilivi.primerprojecte.ui.theme.model.Planeta

@Composable
fun ElementPlaneta(
    planeta: Planeta,
    modifier: Modifier = Modifier
)
{
    Text(
        text = planeta.nom,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(planeta.color)
            .padding(8.dp)
        )
}

@Composable
fun PantallaDePlanetes(
    planetes: List<Planeta>,
    modifier: Modifier = Modifier
)
{
    var indexSeleccionat: Int? by remember{ mutableStateOf(null) }
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    )
    {
        items(planetes){
            ElementPlaneta(it)
            Spacer(Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
fun Planetes()
{
    PrimerProjecteTheme() {
        PantallaDePlanetes(planetes)
    }
}
