package com.saklayen.hackandroid.ui.android

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.saklayen.hackandroid.R
import com.saklayen.hackandroid.base.BaseFragment
import com.saklayen.hackandroid.databinding.FragmentAndroidBinding
import com.saklayen.hackandroid.util.navigate
import kotlinx.android.synthetic.main.fragment_android.*

class AndroidFragment : BaseFragment<FragmentAndroidBinding>(R.layout.fragment_android) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav_graph.setOnClickListener {
            navigate(AndroidFragmentDirections.navigateToNavComponentFragment("Navigation Component"))
        }
        room.setOnClickListener {
            navigate(AndroidFragmentDirections.navigateToRoomFragment())
        }
    }
}