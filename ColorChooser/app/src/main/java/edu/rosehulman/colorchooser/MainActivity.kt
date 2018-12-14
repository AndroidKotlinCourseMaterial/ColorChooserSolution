package edu.rosehulman.colorchooser

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var colorMessage = ColorMessage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            // TODO: Send an email with the message field as the body

        }

        updateUI()
    }

    private fun updateUI() {
        content_main_message.text = colorMessage.message
        content_main_layout.setBackgroundColor(colorMessage.backgroundColor)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_info ->
                // TODO: Launch a new Info Activity that is a ScrollingActivity.
                true
            R.id.action_change_color ->
                // TODO: Launch the InputActivity to get a result
                true

            else -> super.onOptionsItemSelected(item)
        }
    }
}
