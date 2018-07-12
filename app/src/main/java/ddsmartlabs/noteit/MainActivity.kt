package ddsmartlabs.noteit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        val b = findViewById<Button>(R.id.tap)
        b.setOnClickListener { Toast.makeText(baseContext, "First Login", Toast.LENGTH_SHORT).show() }
    }
}
