package bonch.dev.secondhomework.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import bonch.dev.secondhomework.FragmentActivity

import bonch.dev.secondhomework.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private lateinit var nextActivityButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        nextActivityButton = view.findViewById(R.id.next_activity_button)
        nextActivityButton.setOnClickListener {
            (context as FragmentActivity).attachSecondFragment()
        }
        return view
    }


}
