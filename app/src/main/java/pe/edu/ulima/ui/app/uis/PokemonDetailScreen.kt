package pe.edu.ulima.ui.app.uis

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import pe.edu.ulima.ui.app.viewmodels.PokemonDetailViewModel

@Composable
public fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel
){
    val nombre: String by viewModel.name.observeAsState("")
    val url: String by viewModel.url.observeAsState("")
    val talla: Float by viewModel.talla.observeAsState(0f)
    val peso: Float by viewModel.peso.observeAsState(0f)
    val id: Int by viewModel.id.observeAsState(0)

    Column(){
        Row(modifier = Modifier.fillMaxWidth()) {
           Image(
               painter = rememberImagePainter(data = url),
               contentDescription = nombre,
               modifier = Modifier
                   .size(80.dp)
                   .padding(bottom = 10.dp)
               )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text("Nombre: ${nombre}")
                Text("Talla: ${talla} kg")
                Text("Peso: ${peso} cm")
            }
        }
    }
}