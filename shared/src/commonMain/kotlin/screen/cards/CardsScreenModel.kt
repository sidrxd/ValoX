package screen.cards

import cafe.adriel.voyager.core.model.ScreenModel
import connection.ApiHelper
import connection.NetworkResult
import connection.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import model.CardsResponse
import utils.Coroutines

class CardsScreenModel : ScreenModel {

    val cards = MutableStateFlow(ArrayList<CardsResponse.Data>())
    private val repository = MainRepository(ApiHelper.client)

    fun getCards(){
        Coroutines.io {
            val result = repository.getCards()
            when(result){
                is NetworkResult.NetworkError -> {

                }

                is NetworkResult.Loading -> {

                }
                is NetworkResult.Success ->{
                    cards.emit(result.data.data)
                }
            }
        }
    }
}