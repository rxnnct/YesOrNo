package ru.rxnnct.yesorno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import ru.rxnnct.yesorno.model.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: remove
        val db = AppDatabase.getInstance(applicationContext)

        val configDao = db.configDao()
        val isConfigExists = configDao.isConfigExists()

        if (isConfigExists){
            Log.i("RXNNCT", "YES")
        } else {
            Log.i("RXNNCT", "NO")
        }
    }

    // TODO: remove 
    companion object {
        const val isTutorialEnded = "false"
    }
}