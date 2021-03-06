package edu.rosehulman.colorchooser

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            sendEmail()
            // search("smith")
        }

        updateUI()
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("xyz@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "From me")
        intent.putExtra(Intent.EXTRA_TEXT, colorMessage.message)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
        // or startActivity(Intent.createChooser(emailIntent, "Send email to yourself..."));
    }

    fun search(query: String) {
        val intent = Intent(Intent.ACTION_SEARCH)
        intent.putExtra(SearchManager.QUERY, query)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


    private fun updateUI() {
        content_main_message.text = colorMessage.message
        content_main_layout.setBackgroundColor(colorMessage.backgroundColor)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private val REQUEST_CODE_INPUT = 1

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_info -> {
                // TODO: Launch a new Info Activity that is a ScrollingActivity.
                val infoIntent = Intent(this, InfoActivity::class.java)
                startActivity(infoIntent)
                true
            }
            R.id.action_change_color -> {
                // TODO: Launch the InputActivity to get a result
                val inputIntent = Intent(this, InputActivity::class.java)
                inputIntent.putExtra(ColorMessage.EXTRA_MESSAGE, colorMessage)
//                inputIntent.putExtra(ColorMessage.EXTRA_MESSAGE, colorMessage.message)
//                inputIntent.putExtra(ColorMessage.EXTRA_COLOR, colorMessage.backgroundColor)
                startActivityForResult(inputIntent, REQUEST_CODE_INPUT)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_INPUT && resultCode == Activity.RESULT_OK) {
            colorMessage = data?.getParcelableExtra(ColorMessage.EXTRA_MESSAGE) ?: ColorMessage()
//            colorMessage.message = data?.getStringExtra(ColorMessage.EXTRA_MESSAGE) ?: ""
//            colorMessage.backgroundColor = data?.getIntExtra(ColorMessage.EXTRA_COLOR, Color.GRAY) ?: Color.GRAY
            updateUI()
        }
    }
}
