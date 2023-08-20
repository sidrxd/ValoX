package screen.cards

import cafe.adriel.voyager.core.model.ScreenModel
import connection.ApiHelper
import connection.ApiResult
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
                is ApiResult.APIError -> {

                }
                is ApiResult.Error -> {

                }
                is ApiResult.Success ->{
                    cards.emit(result.data.data)
                }
            }
        }
    }
}