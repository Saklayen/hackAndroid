package com.saklayen.hackandroid.ui.home.fragments.navigationComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.saklayen.hackandroid.R
import com.saklayen.hackandroid.util.navigate
import kotlinx.android.synthetic.main.fragment_nav_component.*

class NavComponentFragment : Fragment() {

    val args: NavComponentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_component, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        set_up.setOnClickListener {
            navigate(NavComponentFragmentDirections.navigateToStupFragment())
        }
        safe_args.setOnClickListener {
            navigate(NavComponentFragmentDirections.navigateToSafeArgsFragment())
        }
    }

}