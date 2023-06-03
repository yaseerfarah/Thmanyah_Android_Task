package com.yasser.thmanyahtask.modules.home.di

import com.yasser.thmanyahtask.modules.home.data.repository.BroadcastRepositoryImp
import com.yasser.thmanyahtask.modules.home.domain.repository.BroadcastRepository
import com.yasser.thmanyahtask.modules.login.data.repository.LoginRepositoryImp
import com.yasser.thmanyahtask.modules.login.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BroadcastRepositoryModule {
   @Binds
   abstract fun getBroadcastRepository(imp: BroadcastRepositoryImp):BroadcastRepository

}