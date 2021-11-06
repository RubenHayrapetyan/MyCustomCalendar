package com.ruben.mycustomcalendar.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ruben.mycustomcalendar.R
import com.ruben.mycustomcalendar.ui.CalendarFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, CalendarFragment())
                .commitAllowingStateLoss()
        }
    }
}