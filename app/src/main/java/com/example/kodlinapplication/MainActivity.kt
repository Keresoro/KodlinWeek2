package com.example.kodlinapplication


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            val artist = et1.getText().toString()// the contents of the edit text
            Toast.makeText(this, artist, Toast.LENGTH_SHORT).show()
            doAsync {
                val url = URL(" http://www.free-map.org.uk/course/ws/hits.php?artist=$artist")
                val response = url.readText()
                uiThread {
                    //set the contents of the TextView to the response from the server
                    tv1.setText(response)
                }
            }
        }
    }
}