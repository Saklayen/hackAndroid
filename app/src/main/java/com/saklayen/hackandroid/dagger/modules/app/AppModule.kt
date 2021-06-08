package com.saklayen.hackandroid.dagger.modules.app

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.saklayen.hackandroid.BaseApplication
import com.saklayen.hackandroid.room.Database
import com.saklayen.hackandroid.room.NoteDao
import com.saklayen.hackandroid.room.repository.RoomRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesApplicationContext(mApplication: BaseApplication): Context =
            mApplication.applicationContext

    val MIGRATION: Migration = object : Migration(0, 1) {
        override fun migrate(database: SupportSQLiteDatabase) {
            //database.execSQL("ALTER TABLE CovDistrictInfo");
            Log.e("Migration-->", "is done")
        }
    }
    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
                //  addSampleBooksToDatabase()
            }
        }
    }

    @Singleton
    @Provides
    fun prodividesDatabase(context: Context): Database =
            Room.databaseBuilder(context,Database::class.java, "app_db")
                    .addMigrations(MIGRATION)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(databaseCallback)
                    .build()

    @Singleton
    @Provides
    fun providesRoomRepository(noteDao: NoteDao): RoomRepository = RoomRepository(noteDao)

    @Singleton
    @Provides
    fun providesNoteDao(db: Database): NoteDao = db.getNoteDao()
}