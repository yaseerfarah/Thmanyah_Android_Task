package com.yasser.thmanyahtask.modules.main.presentation.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiModel
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiState
import com.yasser.thmanyahtask.R
import com.yasser.thmanyahtask.base.presentation.navigation.NavigationCoordinator
import com.yasser.thmanyahtask.base.presentation.view.BaseActivity
import com.yasser.thmanyahtask.core.extensions.changeLanguage
import com.yasser.thmanyahtask.databinding.ActivityMainBinding
import com.yasser.thmanyahtask.modules.main.presentation.navigation.MainNavigationEvent
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.BottomNavEnum
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUIEvents
import com.yasser.thmanyahtask.modules.main.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity :BaseActivity<ActivityMainBinding, MainUiModel, MainUiState,MainUIEvents,MainViewModel>() {


    override val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var navigator: NavigationCoordinator<MainNavigationEvent>
    private  val navController:NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navHostFragment.navController
    }
    private var isFirstScreen=true

    override fun bindView(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun handleOrientation() {

    }

    override fun attachBaseContext(newBase: Context?) {
        val context=newBase?.changeLanguage()
        super.attachBaseContext(context)
    }

    override fun initViews() {
       navigator.init(navController)
        onBackPress()
    }

    override fun initListener() {
        binding.bottomNavigation.setOnItemSelectedListener { menuItem->
            when(menuItem.itemId){
                R.id.home-> viewModel.sendEvent(MainUIEvents.NavigateToScreen(BottomNavEnum.HOME))
                R.id.search-> viewModel.sendEvent(MainUIEvents.NavigateToScreen(BottomNavEnum.SEARCH))
                R.id.library-> viewModel.sendEvent(MainUIEvents.NavigateToScreen(BottomNavEnum.LIBRARY))
            }
            true
        }
    }

    override fun render(ui: MainUiModel) {
        isFirstScreen=ui.currentScreen==BottomNavEnum.HOME
        binding.bottomNavigation.selectedItemId=when(ui.currentScreen){
            BottomNavEnum.HOME->R.id.home
            BottomNavEnum.SEARCH->R.id.search
            BottomNavEnum.LIBRARY->R.id.library
        }
    }


    private fun onBackPress() {
        onBackPressedDispatcher.addCallback(
            this /* lifecycle owner */,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (!isFirstScreen)
                        viewModel.sendEvent(MainUIEvents.NavigateToScreen(BottomNavEnum.HOME))
                    else
                        finish()
                }
            })


    }

    companion object{

        fun startInstance(context: Context?) {
            context?.startActivity(
                Intent(context, MainActivity::class.java).apply {
                }
            )
            (context as Activity).finishAffinity()

        }

    }

}