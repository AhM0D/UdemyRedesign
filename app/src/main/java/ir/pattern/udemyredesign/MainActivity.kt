package ir.pattern.udemyredesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.pattern.udemyredesign.ui.detail.DetailFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, DetailFragment.newInstance())
                    .commitNow()
        }
    }
}