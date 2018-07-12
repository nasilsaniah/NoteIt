package ddsmartlabs.noteit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var usn: EditText
    private lateinit var email: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b = findViewById<Button>(R.id.tap)
        usn = findViewById(R.id.usn)
        email = findViewById(R.id.email)
        b.setOnClickListener {
            Toast.makeText(baseContext, "First Login", Toast.LENGTH_SHORT).show()
            saveData()
        }
    }

    private fun saveData() {
        val Usn=usn.text.toString();
        if(Usn.isEmpty())
        {
            usn.error="Please enter USN"
            return
        }
        val Email=email.text.toString();
        if(Email.isEmpty()||!(Email.contains('@')))
        {

            email.error="Please enter valid EmailId"
            return
        }

        val ref= FirebaseDatabase.getInstance().getReference("Students")
        val Id=ref.push().key.toString()
        val Student=Data(Id,Usn,Email)
        ref.child(Id).setValue(Student).addOnCompleteListener {
            Toast.makeText(baseContext,"Data Saved",Toast.LENGTH_SHORT).show()
        }
    }

}

