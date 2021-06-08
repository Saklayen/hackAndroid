package com.saklayen.hackandroid

import com.saklayen.hackandroid.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
    /*override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent.builder().appllication(this).build()
    }*/

   /* override fun applicationInjector(): AndroidInjector<out BaseApplication> =
        DaggerAppComponent.factory().create(this)
*/

}