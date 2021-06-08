package com.saklayen.hackandroid.dagger.modules

import com.saklayen.hackandroid.AuthActivity
import com.saklayen.hackandroid.MainActivity
import com.saklayen.hackandroid.dagger.modules.main.MainModule
import com.saklayen.hackandroid.dagger.scope.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    internal abstract fun contributeAuthActivity(): AuthActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainActivity(): MainActivity
}