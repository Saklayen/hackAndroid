package com.saklayen.hackandroid.dagger.modules.main

import androidx.lifecycle.ViewModel
import com.saklayen.hackandroid.dagger.scope.FragmentScoped
import com.saklayen.hackandroid.dagger.viemodel.ViewModelKey
import com.saklayen.hackandroid.ui.android.AndroidFragment
import com.saklayen.hackandroid.ui.android.fragments.navigationComponent.backStack.BackStackFragment
import com.saklayen.hackandroid.ui.android.fragments.navigationComponent.safeArgs.SafeArgsFragment
import com.saklayen.hackandroid.ui.android.fragments.navigationComponent.setup.StupFragment
import com.saklayen.hackandroid.ui.android.fragments.note.NoteAddFragment
import com.saklayen.hackandroid.ui.android.fragments.note.NoteListFragment
import com.saklayen.hackandroid.ui.android.fragments.note.NoteViewModel
import com.saklayen.hackandroid.ui.android.fragments.room.RoomFragment
import com.saklayen.hackandroid.ui.network.NetworkFragment
import com.saklayen.hackandroid.ui.programming.ProgrammingFragment
import com.saklayen.hackandroid.ui.userInterface.UIFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): AndroidFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeSafeArgsFragment(): SafeArgsFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeStupFragment(): StupFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeBackStackFragment(): BackStackFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeNoteAddFragment(): NoteAddFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeRoomFragment(): RoomFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeProgrammingFragment(): ProgrammingFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeNetworkFragment(): NetworkFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeUIFragment(): UIFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeNoteListFragment(): NoteListFragment

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel::class)
    abstract fun bindANoteViewModel(viewModel: NoteViewModel): ViewModel
}