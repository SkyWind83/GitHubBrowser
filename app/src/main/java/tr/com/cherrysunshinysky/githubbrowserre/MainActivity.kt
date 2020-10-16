package tr.com.cherrysunshinysky.githubbrowserre

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), TextView.OnEditorActionListener {

    private var editTextName: EditText? = null
    private var progressBar: ProgressBar? = null
    private var inputMethodManager: InputMethodManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextName = findViewById(R.id.act_main_et_username)
        progressBar = findViewById(R.id.act_main_pb)
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        editTextName?.setOnEditorActionListener(this)
    }

    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {


        //Make the request
        return if (p0 == editTextName) {
            // Get the username from the edit text
            val userName = editTextName?.text?.trim().toString()
            // Check the editText is not empty
            if (userName.isEmpty() || userName.isBlank()) {
                editTextName?.error = getString(R.string.error_git_user)
            } else {
                // Start the progress bar
                progressBar?.visibility = View.VISIBLE
                // Lover the keyboard
                inputMethodManager?.hideSoftInputFromWindow(editTextName?.windowToken, 0)
            }
            getRepositorisForUsername(userName)
            true
        } else {
            false
        }
    }

    private fun getRepositorisForUsername(userName: String) {

    }
}