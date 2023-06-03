package com.yasser.thmanyahtask.modules.home.presentation.uimodel

import androidx.annotation.StringRes
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.BottomNavEnum

data class HomeUiState(val data:BroadcastUiModel? , val isLoading:Boolean , @StringRes val errorMsg:Int?, val isNetworkError:Boolean)
