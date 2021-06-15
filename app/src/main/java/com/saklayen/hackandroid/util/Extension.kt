package com.saklayen.hackandroid.util

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(direction: NavDirections) = this.findNavController().navigate(direction)
fun Fragment.navigateUp(direction: NavDirections) = this.findNavController().navigateUp()
fun Activity.navigate(@IdRes viewId: Int, direction: NavDirections) =
    this.findNavController(viewId).navigate(direction)

fun Context.changeStatusBarColor(statusBarColor: Int, isLightStatusBar: Boolean) {
    val activity = this as Activity
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val window: Window = activity.window
        window.statusBarColor = ContextCompat.getColor(this, statusBarColor);
        //window.setNavigationBarColor(Color.BLUE);
        if (isLightStatusBar){
            val decor = activity.window.decorView
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

    }

}
fun Context.fullScreenView(statusBarColor: Int, isLightStatusBar: Boolean) {
    val activity = this as Activity
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        //window.setStatusBarColor(activity.getResources().getColor(R.color.white));
        window.navigationBarColor = ContextCompat.getColor(this, statusBarColor)
        if (isLightStatusBar) {
            val decor = activity.window.decorView
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        //decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
    }
}