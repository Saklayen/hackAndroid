package com.saklayen.hackandroid.dagger.viemodel

import androidx.lifecycle.ViewModelProvider
import com.saklayen.hackandroid.dagger.viemodel.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Suppress("unused")
@Module
abstract class ViewModelModuleFactory {
    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}
