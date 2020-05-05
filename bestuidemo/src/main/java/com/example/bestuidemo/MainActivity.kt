package com.example.bestuidemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    var fruitList = ArrayList<Fruit>()
    lateinit var adapter: FruitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        drawerLayout = drawer_layout

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        nav_view.setCheckedItem(R.id.nav_call)
        nav_view.setNavigationItemSelectedListener {
            Toast.makeText(this, "你点击了" + it.title, Toast.LENGTH_SHORT).show()

            drawerLayout.closeDrawers()
            return@setNavigationItemSelectedListener true
        }

        fab.setOnClickListener {
            Snackbar.make(it, "data delete", Snackbar.LENGTH_SHORT)
                .setAction("Undo", View.OnClickListener {
                    Toast.makeText(this, "你点击了悬浮按钮", Toast.LENGTH_SHORT).show()
                })
                .show()
        }

        initFruit()
        recycleView.layoutManager = GridLayoutManager(this, 1)
        adapter = FruitAdapter(fruitList)
        recycleView.adapter = adapter

        swipe_refresh.setColorSchemeResources(R.color.colorPrimary)
        swipe_refresh.setOnRefreshListener { refreshFruit() }
    }

    fun refreshFruit() {
        Thread(Runnable {
            Thread.sleep(2000)

            runOnUiThread(object : Runnable {
                override fun run() {
                    initFruit()
                    adapter.notifyDataSetChanged()
                    swipe_refresh.isRefreshing = false
                }

            })
        }).start()
    }

    fun initFruit() {
        fruitList.clear()
        for (i in 0..20) {
            fruitList.add(Fruit(randomName(), R.drawable.cherry))
            fruitList.add(Fruit(randomName(), R.drawable.org))
            fruitList.add(Fruit(randomName(), R.drawable.stra))
        }
    }

    fun randomName(): String {
        var rand = Random
        var names = ArrayList<String>()
        names.add("Cerasus pseudocerasus")
        names.add("Citrus maxima (Burm) Merr")
        names.add("Fragaria × ananassa Duch")

        return names.get(rand.nextInt(0, 3))
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
            R.id.backup -> Toast.makeText(this, "You click backup", Toast.LENGTH_SHORT).show()
            R.id.delete -> Toast.makeText(this, "You click delete", Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, "You click settings", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}
