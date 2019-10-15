package bonch.dev.secondhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import bonch.dev.secondhomework.fragments.FirstFragment
import bonch.dev.secondhomework.fragments.SecondFragment

class FragmentActivity: AppCompatActivity() {

    val fragmentManager = supportFragmentManager
    val firstFragmentName = "FIRST FRAGMENT"
    val secondFragmentName = "SECOND FRAGMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val firstFragment = FirstFragment()
        fragmentManager
            .beginTransaction()
            .add(R.id.fragment, firstFragment)
            //.addToBackStack(firstFragmentName)
            .commit()
    }

    fun attachSecondFragment(){
        val secondFragment = SecondFragment()
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment, secondFragment)
            .addToBackStack(secondFragmentName)
            .commit()
    }

}
