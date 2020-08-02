package com.fabiel.casas.amazon_products.view.viewmodel

import androidx.lifecycle.*
import com.fabiel.casas.amazon_products.data.config.ApiResult
import com.fabiel.casas.amazon_products.data.models.Product
import com.fabiel.casas.amazon_products.data.repository.AmazonProductsRepositoryImpl
import com.fabiel.casas.amazon_products.usecases.AmazonProductsUseCase
import com.fabiel.casas.amazon_products.usecases.AmazonProductsUseCaseImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val useCase: AmazonProductsUseCase =
        AmazonProductsUseCaseImpl(AmazonProductsRepositoryImpl())
    val productListError: MutableLiveData<String> = MutableLiveData()
    val productList: MutableLiveData<List<Product>> = MutableLiveData()

    fun getProducts(search: String = "") {
        viewModelScope.launch(Dispatchers.Default) {
            val result = useCase.invoke(search)
            when(result) {
                is ApiResult.Success -> productList.postValue(result.data)
                else -> productListError.postValue("Apologies this services is not available right now.")
            }
        }
    }
}