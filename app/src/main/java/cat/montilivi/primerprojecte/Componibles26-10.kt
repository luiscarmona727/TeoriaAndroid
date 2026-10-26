package cat.montilivi.primerprojecte

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class Componibles26 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun ComponibleMostrarHora(){

    val dataCreacio = remember { mutableStateOf(LocalDateTime.now()) }
    val dataActual = mutableStateOf(LocalDateTime.now())
    val formatejadorData= DateTimeFormatter.ofPattern("hh:mm:ss-SS")
        .withZone(ZoneId.systemDefault())
    Column(){
        Text("Data creació: ${formatejadorData.format(dataCreacio.value)}")
        Text("Data actual: ${formatejadorData.format(dataActual.value)}")
        Button(
            onClick = {
                dataActual.value=LocalDateTime.now()
            }
        ){
            Text("Actualitza")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormulariTemperatura(){
    var poblacio by remember { mutableStateOf("") }
    var temperatura by remember { mutableStateOf("0") }
    val errorTemperatura=temperatura.toIntOrNull()==null
    Column(){
        Text("Temperatura avui",
            style= MaterialTheme.typography.titleLarge.copy(
                Color(0xFFFF0000)
            ))
        Text("Entra la població")
        TextField(value=poblacio, onValueChange = {poblacio=it})
        Text("Entra la temperatura")
        ComposableTermometreStateLess(
            temperatura=temperatura,
            onCanviarTemperatura={temp -> temperatura=temp},
            errorTemperatura=errorTemperatura)
        //ComposableTermometreStateFull()
        Button(onClick = {
            if(!errorTemperatura&&poblacio.isNotEmpty())
                Log.e("DEBUG","Envio: ${poblacio},${temperatura}")
            else
                Log.e("DEBUG","Tens un error")
        }){
            Text("Enviar")
        }
    }
}

@Composable
fun ComposableTermometreStateLess(
    temperatura: String,
    onCanviarTemperatura: (String) -> Unit,
    errorTemperatura: Boolean
) {
    var icona = R.drawable.tancar

    if (!errorTemperatura) {
        val temperaturaInt = temperatura.toIntOrNull()
        if (temperaturaInt != null) {
            if (temperaturaInt >= 0)
                icona = R.drawable.sol
            else
                icona = R.drawable.neu
        }
    }

    Row(verticalAlignment = Alignment.CenterVertically){
        TextField(
            value = temperatura,
            onValueChange = { onCanviarTemperatura(it) },
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp)
                .border(
                    width = 2.dp,
                    color = if (errorTemperatura) Color(0xFFFF0000) else Color.Black
                )
        )
        Icon(painter = painterResource(icona), contentDescription = "")
    }
}

@Composable
fun ComposableTermometreStateFull() {
    val temperatura = remember { mutableStateOf("0") }
    val error = temperatura.value.toIntOrNull() == null

    var icona = R.drawable.tancar

    if (!error) {
        val temperaturaInt = temperatura.value.toIntOrNull()
        if (temperaturaInt != null) {
            if (temperaturaInt >= 0)
                icona = R.drawable.sol
            else
                icona = R.drawable.neu
        }
    }

    Row(verticalAlignment = Alignment.CenterVertically){
        TextField(
            value = temperatura.value,
            onValueChange = { temperatura.value = it },
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp)
                .border(
                    width = 2.dp,
                    color = if (error) Color(0xFFFF0000) else Color.Black
                )
        )
        Icon(painter = painterResource(icona), contentDescription = "")
    }
}

@Preview(showBackground = true)
@Composable
fun ComposableSelector() {
    val opcions = listOf("Android", "Windows", "IOS", "Linux")
    var indexSeleccionat by remember { mutableStateOf(0) }

    Box(Modifier.padding(top = 64.dp)) {
        SelectorHoritzontal(
            opcions = opcions,
            onOpcioSeleccionada = { indexSeleccionat = it },
            indexOpcioSeleccionada = indexSeleccionat
        )
    }
}

@Composable
fun SelectorHoritzontal(
    opcions: List<String>,
    onOpcioSeleccionada: (Int) -> Unit,
    indexOpcioSeleccionada: Int
) {
    LazyRow {
        itemsIndexed(opcions) { index, opcio ->
            val colorFons =
                if (index == indexOpcioSeleccionada) Color(0xFFFF0000) else Color(0xFF00FF00)
            Text(
                text = opcio,
                modifier = Modifier
                    .background(colorFons)
                    .clickable(enabled = true, onClick = { onOpcioSeleccionada(index) })
                    .padding(8.dp)
            )
        }
    }
}
