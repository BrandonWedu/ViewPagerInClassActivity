package edu.temple.viewpagerinclasssctivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    val newButton : Button by lazy {
        findViewById(R.id.button)
    }

    private val viewPager: ViewPager2 by lazy {
        findViewById(R.id.viewPager)
    }
    var numberOfFragments = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = object: FragmentStateAdapter(this) {
            override fun getItemCount() = numberOfFragments

            override fun createFragment(position: Int) = TextFragment.newInstance((position + 1).toString())
        }

        newButton.setOnClickListener {
            numberOfFragments++
            (viewPager.adapter as FragmentStateAdapter).notifyDataSetChanged()
            viewPager.setCurrentItem(numberOfFragments-1, true)
        }


    }

}