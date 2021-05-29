package com.yusrilapps.prolang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvLangs: RecyclerView
    private var list: ArrayList<Lang> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        rvLangs = findViewById(R.id.rv_languages)
        rvLangs.setHasFixedSize(true)
        showAllList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMenuAction(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMenuAction(selectedAction: Int) {
        when(selectedAction) {
            R.id.action_about -> {
                val aboutActivityIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutActivityIntent)
            }

            R.id.action_all_list -> {
                showAllList()
            }

            R.id.action_fav_list -> {
                showFavList()
            }
        }
    }

    private fun showAllList() {
        list.clear()
        list.addAll(LangsData.listData)
        showList()
        supportActionBar?.title = "Programming Language"
    }

    private fun showFavList() {
        list.clear()
        list.addAll(LangsData.favoriteListData)
        showList()
        supportActionBar?.title = "Favorite Language"
    }

    private fun showList() {
        rvLangs.layoutManager = LinearLayoutManager(this)
        val listLangAdapter = ListLangAdapter(list)
        rvLangs.adapter = listLangAdapter

        listLangAdapter.setOnItemClickCallback(object : ListLangAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Lang) {
                moveToDetailActivityWith(data)
            }
        })
    }

    private fun moveToDetailActivityWith(lang: Lang) {
        val detailActivityIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailActivityIntent.putExtra(DetailActivity.EXTRA_ID, lang.id)
        startActivity(detailActivityIntent)
    }
}