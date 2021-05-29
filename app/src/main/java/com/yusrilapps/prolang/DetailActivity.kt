package com.yusrilapps.prolang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var favButtonView: Button
    private lateinit var shareButtonView: Button
    private lateinit var lang: Lang

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val langId = intent.getIntExtra(EXTRA_ID, 0)
        lang = getLang(langId)

        supportActionBar?.title = lang.name

        favButtonView = findViewById(R.id.button_fav)
        shareButtonView = findViewById(R.id.button_share)

        favButtonView.setOnClickListener(this)
        shareButtonView.setOnClickListener(this)

        renderContent()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_fav -> {
                if (LangsData.favoriteLists.contains(lang.id)) {
                    LangsData.favoriteLists.remove(lang.id)
                    lang.favorite = false
                    Toast.makeText(this, "Unfavorited", Toast.LENGTH_SHORT).show()
                } else {
                    LangsData.favoriteLists.add(lang.id)
                    lang.favorite = true
                    Toast.makeText(this, "Favorited", Toast.LENGTH_SHORT).show()
                }
                renderContent()
            }

            R.id.button_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Let's learn ${lang.name} together with the documentation on ${lang.docUrl}")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, lang.name)
                startActivity(shareIntent)
            }
        }
    }

    private fun getLang(id: Int): Lang = LangsData.listData[id]

    private fun getCreatedDate(lang: Lang) = "Created On ${lang.created}"

    private fun renderContent() {
        val posterView: ImageView = findViewById(R.id.img_poster)
        Glide.with(this)
            .load(lang.logo)
            .into(posterView)

        val nameView: TextView = findViewById(R.id.tv_name)
        nameView.text = lang.name

        val createdOnView: TextView = findViewById(R.id.tv_created)
        createdOnView.text = getCreatedDate(lang)
        favButtonView.text = if (lang.favorite) {
            "Unfavorite"
        } else {
            "favorite"
        }

        val descriptionView: TextView = findViewById(R.id.tv_description)
        descriptionView.text = lang.description
    }
}