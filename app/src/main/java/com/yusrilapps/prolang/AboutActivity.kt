package com.yusrilapps.prolang

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "About Developer"

        val visitButton: Button = findViewById(R.id.btn_visit_web)
        visitButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_visit_web -> {
                val url = "https://yusril-adr.github.io/"
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                webIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(webIntent)
            }
        }
    }
}