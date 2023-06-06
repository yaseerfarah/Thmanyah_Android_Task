package com.yasser.thmanyahtask.modules.splash.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.yasser.thmanyahtask.base.presentation.navigation.NavigationCoordinator
import com.yasser.thmanyahtask.base.presentation.view.BaseActivity
import com.yasser.thmanyahtask.core.navigation.RootNavigationEvent
import com.yasser.thmanyahtask.databinding.ActivityMainBinding
import com.yasser.thmanyahtask.databinding.ActivitySplashBinding
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUIEvents
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiModel
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiState
import com.yasser.thmanyahtask.modules.main.presentation.viewmodel.MainViewModel
import com.yasser.thmanyahtask.modules.splash.presentation.uimodel.SplashUIEvents
import com.yasser.thmanyahtask.modules.splash.presentation.uimodel.SplashUiModel
import com.yasser.thmanyahtask.modules.splash.presentation.uimodel.SplashUiState
import com.yasser.thmanyahtask.modules.splash.presentation.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashUiModel, SplashUiState, SplashUIEvents, SplashViewModel>(){
    override val viewModel by viewModels<SplashViewModel>()

    @Inject
    lateinit var rootNavigation:NavigationCoordinator<RootNavigationEvent>

    override fun bindView(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun handleOrientation() {

    }

    override fun initViews() {
        viewModel.sendEvent(SplashUIEvents.StartSplashDelay)
    }

    override fun initListener() {

    }

    override fun render(ui: SplashUiModel) {
        if (ui.navigateToNextScreen)
            rootNavigation.onStart(this)
    }


}