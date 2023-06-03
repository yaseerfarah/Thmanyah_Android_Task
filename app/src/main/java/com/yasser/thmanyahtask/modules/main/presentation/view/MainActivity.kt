package com.yasser.thmanyahtask.modules.main.presentation.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.moviecompose.modules.details.presentation.uimodel.MainUiModel
import com.example.moviecompose.modules.details.presentation.uimodel.MainUiState
import com.yasser.thmanyahtask.R
import com.yasser.thmanyahtask.base.presentation.navigation.NavigationCoordinator
import com.yasser.thmanyahtask.base.presentation.view.BaseActivity
import com.yasser.thmanyahtask.databinding.ActivityMainBinding
import com.yasser.thmanyahtask.modules.main.presentation.navigation.MainNavigationEvent
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUIEffects
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUIEvents
import com.yasser.thmanyahtask.modules.main.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity :BaseActivity<ActivityMainBinding,MainUiModel,MainUiState,MainUIEffects,MainUIEvents,MainViewModel>() {


    override val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var navigator: NavigationCoordinator<MainNavigationEvent>
    private lateinit var navController:NavController

    override fun bindView(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun handleOrientation() {

    }

    override fun initViews() {
        navController= Navigation.findNavController(
            this,
            R.id.main_nav_graph
        )
       navigator.init(navigator)
    }

    override fun initListener() {
        TODO("Not yet implemented")
    }

    override fun render(ui: MainUiModel) {
        TODO("Not yet implemented")
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