package bonch.dev.secondhomework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import bonch.dev.secondhomework.fragments.MyFragment

class FragmentActivity: AppCompatActivity() {
    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var attachFragmentButton: Button
    private lateinit var textField: EditText

    companion object{
        val IS_BUTTON_CLICKED = "IS_BUTTON_CLICKED"
        val COUNTER = "COUNTER"
        val INPUT_TEXT = "INPUT_TEXT"
    }


    private var counter = 0
    private var isClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        initActivity()
    }

    fun initViews(){
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        nextActivityButton = findViewById(R.id.next_activity_button)
        textField = findViewById(R.id.text_field)
        attachFragmentButton = findViewById(R.id.attach_fragment_button)
    }

    fun setOnClickListeners(){

        indicatorButton.setOnClickListener {
            indicatorButton.isEnabled = false
            isClicked = true
        }

        counterButton.setOnClickListener {
            counter++
            counterButton.text = "нажато ${counter} раз"
        }

        nextActivityButton.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(COUNTER, counter)
            intent.putExtra(IS_BUTTON_CLICKED, isClicked)
            var text = textField.text.toString()
            intent.putExtra(INPUT_TEXT, text)

            startActivity(intent)

        }

        attachFragmentButton.setOnClickListener {



            val fragmentManager = supportFragmentManager

            val arguments = Bundle()
            arguments.putInt(COUNTER, counter)
            arguments.putBoolean(IS_BUTTON_CLICKED, isClicked)
            var text = textField.text.toString()
            arguments.putString(INPUT_TEXT, text)

            val fragment = MyFragment()
            fragment.arguments = arguments

            fragmentManager
                .beginTransaction()
                .add(R.id.fragment_section, fragment)
                .addToBackStack("fragment")
                .commit()
        }
    }

    fun initActivity(){
        initViews()
        setOnClickListeners()
    }

}
