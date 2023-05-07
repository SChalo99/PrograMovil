package pe.edu.ulima.ui.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.services.pokemonsList

class PokemonDetailViewModel: ViewModel() {
    val _id = MutableLiveData<Int>(0)
    val id: LiveData<Int> = _id
    fun updateId(it: Int) {
        _id.postValue(it)
    }

    val _url = MutableLiveData<String>("")
    val url: LiveData<String> = _url
    fun updateUrl(it: String) {
        _url.postValue(it)
    }

    val _name = MutableLiveData<String>("")
    val name: LiveData<String> = _name

    fun updateName(it: String) {
        _name.postValue(it)
    }

    val _talla = MutableLiveData<Float>(0f)
    val talla: LiveData<Float> = _talla
    fun updateTalla(it: Float) {
        _talla.postValue(it)
    }

    val _peso = MutableLiveData<Float>(0f)
    val peso: LiveData<Float> = _peso
    fun updatePeso(it: Float) {
        _peso.postValue(it)
    }

    fun getPokemon(id: Int){
        for(pokemon in pokemonsList)
        {
            if (pokemon.id == id){
                this.updatePeso(pokemon.peso)
                this.updateTalla(pokemon.talla)
                this.updateUrl(pokemon.url)
                this.updateName(pokemon.nombre)
            }
        }
    }
}
