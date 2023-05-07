package pe.edu.ulima.ui.app.uis

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import pe.edu.ulima.ui.app.viewmodels.PokemonViewModel

@Preview
@Composable
public fun PokemonScreenPreview(){
    /*PokemonScreen(
        PokemonViewModel(),
        NavHostController
    )*/
}

@Composable
public fun PokemonScreen(
    viewModel: PokemonViewModel,
    navController: NavHostController
){
    viewModel.setPokemons()
    Column(){
        for (pokemon in viewModel.pokemons!!) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .clickable {
                       navController.navigate("/pokemon/detalle?pokemon_id=${pokemon.id.toString()}")
                    }
            ){
                Image(
                    painter = rememberImagePainter(data = pokemon.url),
                    contentDescription = pokemon.nombre,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(bottom = 10.dp),
                )
            }
            Divider (
                color = Color.Gray,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
        }
    }
}