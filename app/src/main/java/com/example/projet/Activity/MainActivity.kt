package com.example.projet.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.projet.R
import kotlinx.android.synthetic.main.activity_loading.*

class MainActivity : AppCompatActivity() {

    override fun onDestroy() {
        super.onDestroy()
        overridePendingTransition(
            R.anim.fade_in,
            R.anim.fade_out
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        id_logo.startAnimation(AnimationUtils.loadAnimation(this,
            R.anim.splash_in
        ))

        Handler().postDelayed({
            id_logo.startAnimation(AnimationUtils.loadAnimation(this,
                R.anim.splash_out
            ))
            Handler().postDelayed ({
                    id_logo.visibility = View.GONE
                    startActivity(Intent(this, StartActivity::class.java))
            }, 500)
        }, 2500)
    }
}
