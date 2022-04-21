package ru.rxnnct.yesorno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: remove
//        val db = AppDatabase.getInstance(applicationContext, CoroutineScope(SupervisorJob()))

//        val configDao = db.settingsDao()
//        val isConfigExists = configDao.isSettingsExists()

//        if (isConfigExists){
//            Log.i("RXNNCT", "YES")
//        } else {
//            Log.i("RXNNCT", "NO")
//        }
    }

    // TODO: remove 
    companion object {
        const val isTutorialEnded = "false"
    }
}