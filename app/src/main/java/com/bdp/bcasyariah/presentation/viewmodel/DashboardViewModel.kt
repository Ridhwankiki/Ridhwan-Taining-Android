package com.bdp.bcasyariah.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bdp.bcasyariah.R
import com.bdp.bcasyariah.data.remote.MenuDashboardRemoteDatasource
import com.bdp.bcasyariah.model.AccountNumberModel
import com.bdp.bcasyariah.model.MenuDashboard
import com.bdp.bcasyariah.model.MenuDashboardModel
import com.bdp.bcasyariah.model.MenuDashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val menuDashboardRemoteDatasource: MenuDashboardRemoteDatasource
) : ViewModel() {

    private val _homeMenu = MutableLiveData<MenuDashboardResponse>()
    val homeMenu: LiveData<MenuDashboardResponse>
        get() = _homeMenu

    private val _homeMenuError = MutableLiveData<String>()
    val homeMenuError: LiveData<String>
        get() = _homeMenuError

    private val _accountNumber = MutableLiveData<List<AccountNumberModel>>()

    val accountNumber: LiveData<List<AccountNumberModel>>
        get() = _accountNumber

    fun getHomeMenu() = viewModelScope.launch(Dispatchers.IO) {
        menuDashboardRemoteDatasource.getMenuDashboard().let {
            if (it.isSuccessful) {
                _homeMenu.postValue(it.body())
            }else {
                _homeMenuError.postValue(it.message())
            }
        }
    }

    private fun populationDataAccountNumber(): List<AccountNumberModel> {
        return listOf(
            AccountNumberModel(
                savingType = 1,
                numberRekening = 1234567890,
                balanceAmount = "Rp.1.000.000"
            ),
            AccountNumberModel(
                savingType = 0,
                numberRekening = 0,
                balanceAmount = ""
            ),
            AccountNumberModel(
                savingType = 0,
                numberRekening = 0,
                balanceAmount = ""
            ),
        )
    }

    fun getAccountNumber() = viewModelScope.launch(Dispatchers.IO) {
        _accountNumber.postValue(populationDataAccountNumber())
    }

}