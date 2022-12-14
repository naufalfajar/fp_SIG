package id.nphew.tes.finalproject_sig

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import id.nphew.tes.finalproject_sig.database.AppRoomDatabase

class App :MultiDexApplication() {

    val database:AppRoomDatabase by lazy { AppRoomDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}