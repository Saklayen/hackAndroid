package com.saklayen.hackandroid.base

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.ViewPumpAppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.saklayen.hackandroid.base.ui.ActivityScreenSwitcher
import com.saklayen.hackandroid.base.ui.NavigationHost
import com.saklayen.hackandroid.ui.custom.CustomDialog
import com.zeugmasolutions.localehelper.LocaleHelper
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegate
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegateImpl
import dagger.android.support.DaggerAppCompatActivity
import dev.b3nedikt.app_locale.AppLocale
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import java.util.*
import javax.inject.Inject


abstract class BaseActivity<T : ViewDataBinding> constructor(@LayoutRes private val mContentLayoutId: Int) :
    DaggerAppCompatActivity(),
    NavigationHost {
    @Inject
    lateinit var mActivityScreenSwitcher: ActivityScreenSwitcher
    protected val mBinding: T by lazy(LazyThreadSafetyMode.NONE) {
        DataBindingUtil.setContentView<T>(this, mContentLayoutId)
    }

    private val localeDelegate: LocaleHelperActivityDelegate = LocaleHelperActivityDelegateImpl()
    var mActivity: Activity? = null

    override fun attachBaseContext(newBase: Context) {
        val localeDelegate = LocaleHelperActivityDelegateImpl()
        val context = localeDelegate.attachBaseContext(newBase)
        super.attachBaseContext(ViewPumpContextWrapper.wrap(context))

    }

    private val appCompatDelegate: AppCompatDelegate by lazy {
        ViewPumpAppCompatDelegate(
            baseDelegate = super.getDelegate(),
            baseContext = this,
            wrapContext = { baseContext -> AppLocale.wrap(baseContext) }
        )
    }

    override fun getDelegate(): AppCompatDelegate {
        return appCompatDelegate
    }

    var noInternetDialog: CustomDialog? = null
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adjustFontScale(resources.configuration)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        mActivity=this
        mBinding.lifecycleOwner = this
    }

    override fun onResume() {
        mActivityScreenSwitcher.attach(this)
        super.onResume()
    }

    override fun onPause() {
        mActivityScreenSwitcher.detach()
        super.onPause()
    }

    override fun createConfigurationContext(overrideConfiguration: Configuration): Context {
        val context = super.createConfigurationContext(overrideConfiguration)
        return LocaleHelper.onAttach(context)
    }

    open fun updateLocale(locale: Locale) {

    }

    override fun registerToolbarWithNavigation(toolbar: Toolbar) {
    }



    protected fun onArrowClick() = mActivityScreenSwitcher.goBack()

    override fun activityScreenSwitcher() = mActivityScreenSwitcher
     @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
     fun adjustFontScale(configuration: Configuration?) {

        configuration?.let {
            it.fontScale = 1.0F
            val metrics: DisplayMetrics = resources.displayMetrics
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                val display =display
                display?.getRealMetrics(metrics)
            } else {
                @Suppress("DEPRECATION")
                val display = windowManager.defaultDisplay
                @Suppress("DEPRECATION")
                display.getMetrics(metrics)
            }
            metrics.scaledDensity = configuration.fontScale * metrics.density

            baseContext.applicationContext.createConfigurationContext(it)
            baseContext.resources.displayMetrics.setTo(metrics)

        }
        }
}

