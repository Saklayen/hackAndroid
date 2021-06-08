package com.saklayen.hackandroid.ui.home.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.saklayen.hackandroid.R
import com.saklayen.hackandroid.dagger.viemodel.AppViewModelFactory
import com.saklayen.hackandroid.room.Note
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_note_add.*
import javax.inject.Inject

class NoteAddFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel: NoteViewModel by navGraphViewModels(R.id.main_nav_graph) { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this frag
        return inflater.inflate(R.layout.fragment_note_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add.setOnClickListener {
            var note = Note(0,title.text.toString(),description.text.toString())
            viewModel.saveNote(note)
        }

    }

}