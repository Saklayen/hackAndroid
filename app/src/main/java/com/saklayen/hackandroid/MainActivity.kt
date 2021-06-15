package com.saklayen.hackandroid

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.saklayen.hackandroid.base.BaseActivity
import com.saklayen.hackandroid.databinding.ActivityMainBinding
import com.saklayen.hackandroid.util.changeStatusBarColor
import com.saklayen.hackandroid.util.fullScreenView
import com.saklayen.hackandroid.util.setupNavController

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mNavController by lazy { findNavController(R.id.nav_host_fragment) }
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        super.onCreate(savedInstanceState)
        this.changeStatusBarColor(R.color.purple_500,false)

        mBinding.bottomNavView.setupNavController(mNavController)
        mNavController.addOnDestinationChangedListener { _, destination, _ ->
            val selectId = destination.id
            val isTopLevelDestination = TOP_LEVEL_DESTINATIONS.contains(selectId)
            mBinding.bottomNavView.visibility =
                if (isTopLevelDestination) View.VISIBLE else View.GONE
        }
    }

    companion object {
        private val TOP_LEVEL_DESTINATIONS = setOf(
            R.id.androidFragment,
            R.id.programmingFragment,
            R.id.UIFragment,
            R.id.networkFragment
        )

    }

    override fun registerToolbarWithNavigation(toolbar: Toolbar) {
        val appBarConfiguration = AppBarConfiguration(TOP_LEVEL_DESTINATIONS)
        toolbar.setupWithNavController(mNavController, appBarConfiguration)
    }
}