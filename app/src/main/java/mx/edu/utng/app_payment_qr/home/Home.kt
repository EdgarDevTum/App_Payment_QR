package mx.edu.utng.app_payment_qr.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import mx.edu.utng.app_payment_qr.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class Home : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))

        val persoN = findViewById<TextView>(R.id.textView2)

        val dateFormat: DateFormat = SimpleDateFormat("HH:mm aa")
        val dt = Date()
        val currentDateTimeString = DateFormat.getDateTimeInstance().format(dt)

        var salud =""

        val sub = dateFormat.format(dt)

        val day = sub.substring(6,8)

        if (day.equals("AM")){
            salud="BUENOS DIAS"

        }else{
            salud="BUENAS NOCHES"
        }

        persoN.setText("HOLA "+salud)


        val segu = Story()


        val home = findViewById<BottomNavigationView>(R.id.bottom_nav)



        home.setSelectedItemId(R.id.list)

        home.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){

                R.id.list -> {val intent = Intent(this@Home, Story::class.java)
                    startActivity(intent)}

            }
            return@setOnNavigationItemSelectedListener true
        }

    }



    fun closeSession(view: View) {
        finish()
    }

    fun scann(view: View) {
        val scann = Intent(this, ScannP::class.java)
        startActivity(scann)


    }


}