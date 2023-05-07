package pe.edu.ulima.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.ulima.ui.app.uis.PokemonDetailScreen
import pe.edu.ulima.ui.app.uis.PokemonScreen
import pe.edu.ulima.ui.app.viewmodels.PokemonDetailViewModel
import pe.edu.ulima.ui.app.viewmodels.PokemonViewModel

@Composable
fun AppNavigation(
    pokemonScreenModel: PokemonViewModel,
    pokemonDetailViewModel: PokemonDetailViewModel
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val pokemonIdParam = navBackStackEntry?.arguments?.getInt("pokemon_id")
    
    NavHost(
        navController = navController,
        startDestination = "/pokemon"
    ){
        composable(route ="/pokemon"){
            PokemonScreen(viewModel = pokemonScreenModel, navController)

        }
        composable(
            route ="/pokemon/detalle?pokemon_id={pokemon_id}",
            arguments = listOf(navArgument("pokemon_id"){
            type = NavType.IntType
            defaultValue = 0
        })){
            pokemonDetailViewModel.getPokemon(pokemonIdParam!!)
            PokemonDetailScreen(viewModel = pokemonDetailViewModel)
        }
    }
}