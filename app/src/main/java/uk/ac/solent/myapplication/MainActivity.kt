package uk.ac.solent.myapplication

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${et1.text}")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                toast("No activity to handle this intent")
            }
        }

        btn2.setOnClickListener{

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://${et2.text}"))

            if(intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            } else {
                toast("No activity to handle URL!")
            }

        }

    }


}
