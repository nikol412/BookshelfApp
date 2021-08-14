package com.nikol.bookshelfapp


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        val mToolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)


        val searchItem: MenuItem = menu!!.findItem(R.id.action_search)
        searchItem.expandActionView()
        val searchView: SearchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                if (newText.isNotBlank()) {
                    Toast.makeText(this@MainActivity, "some query", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "empty text", Toast.LENGTH_SHORT).show()
                }
                return true
            }
        })
        return true
    }
}