package com.yasser.thmanyahtask.modules.home.presentation.view

import androidx.fragment.app.viewModels
import com.yasser.thmanyahtask.base.presentation.view.BaseFragment
import com.yasser.thmanyahtask.databinding.FragmentHomeBinding
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.HomeUIEffects
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.HomeUIEvents
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.HomeUiModel
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.HomeUiState
import com.yasser.thmanyahtask.modules.home.presentation.viewmodel.HomeViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding,HomeUiModel,HomeUiState,HomeUIEffects,HomeUIEvents,HomeViewModel>() {
    override val viewModel by viewModels<HomeViewModel>()

    override fun bindView(): FragmentHomeBinding {
       return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initViews() {

    }

    override fun initListener() {

    }

    override fun render(ui: HomeUiModel) {

    }
}