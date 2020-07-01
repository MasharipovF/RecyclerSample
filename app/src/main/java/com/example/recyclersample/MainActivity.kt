package com.example.recyclersample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (fragmentContainer != null) {

            if (savedInstanceState != null) {
                return
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, FragmentList.newInstance("", ""), FragmentList.TAG)
                .addToBackStack("stack").commit()
        }

    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, tag).addToBackStack("stack").commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }

}
