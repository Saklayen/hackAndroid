package com.saklayen.hackandroid.base.ui

interface ScreenSwitcher<S : Screen> {
    fun open(mScreen: S)

    fun goBack()
}
