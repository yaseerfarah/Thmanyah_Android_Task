package com.yasser.thmanyahtask.modules.login.di

import com.yasser.thmanyahtask.modules.login.data.repository.LoginRepositoryImp
import com.yasser.thmanyahtask.modules.login.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginRepositoryModule {
   @Binds
   abstract fun getLoginRepository(imp: LoginRepositoryImp):LoginRepository

}