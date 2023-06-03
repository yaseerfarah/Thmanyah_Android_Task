package com.yasser.thmanyahtask.modules.home.presentation.uimodel

import androidx.annotation.StringRes
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.BottomNavEnum

data class HomeUiModel(
    val data:BroadcastUiModel? ,
    val showLoading:Boolean ,
    @StringRes val errorMsg:Int?,
    val showEmptyState:Boolean,
    val showNetworkError:Boolean,
    val showUnexpectedError:Boolean,


)
