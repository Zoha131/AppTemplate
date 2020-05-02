package com.conceptgang.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.conceptgang.sample.fragment.FirstFragment
import com.conceptgang.sample.fragment.SecondFragment
import com.conceptgang.sample.fragment.ThirdFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutList = ArrayList<Pair<String, Class<out Fragment>>>()
        layoutList.add(Pair("First Page", FirstFragment::class.java))
        layoutList.add(Pair("Second Page", SecondFragment::class.java))
        layoutList.add(Pair("Third Page", ThirdFragment::class.java))

        viewPager2.adapter = TestFragmentAdapter(this, layoutList)
        TabLayoutMediator(tablayout, viewPager2) { tab, position ->
            tab.text = layoutList[position].first
        }.attach()
    }
}


class TestFragmentAdapter(
    fa: FragmentActivity,
    private val data: ArrayList<Pair<String, Class<out Fragment>>>
) : FragmentStateAdapter(fa) {


    override fun getItemCount(): Int = data.size

    override fun createFragment(position: Int): Fragment {

        return data[position].second.newInstance()

    }

}