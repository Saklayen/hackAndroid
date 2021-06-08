package com.saklayen.hackandroid.dagger

import android.app.Application
import com.saklayen.hackandroid.BaseApplication
import com.saklayen.hackandroid.dagger.modules.ActivityBindingModule
import com.saklayen.hackandroid.dagger.modules.app.AppModule
import com.saklayen.hackandroid.dagger.viemodel.ViewModelModuleFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        AppModule::class,
        ViewModelModuleFactory::class,
    ]
)
interface AppComponent: AndroidInjector<BaseApplication> {

    /*@Component.Factory
    interface Factory : AndroidInjector.Factory<BaseApplication>*/
    @Component.Builder
    interface Builder{
        fun build(): AppComponent

        @BindsInstance
        fun appllication(application: Application): Builder
    }

}