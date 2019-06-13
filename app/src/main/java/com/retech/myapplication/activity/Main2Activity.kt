package com.retech.myapplication.activity

import android.accounts.Account
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.internal.BottomNavigationMenu
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.widget.Toast
import com.retech.myapplication.R
import com.retech.myapplication.fragment.AccountFragment
import com.retech.myapplication.fragment.MainFragment
import com.retech.myapplication.fragment.PlusOneFragment
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(),
    MainFragment.OnFragmentInteractionListener,
    PlusOneFragment.OnFragmentInteractionListener,
    AccountFragment.OnFragmentInteractionListener,
    BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        Toast.makeText(this, "Clicked ${menuItem.title}", Toast.LENGTH_SHORT).show()

        var fragment: Fragment = MainFragment.newInstance()

        when(menuItem.itemId) {
            R.id.bottom_menu_map-> fragment = PlusOneFragment.newInstance()
            R.id.bottom_menu_account -> fragment = AccountFragment.newInstance()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

        return true
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MainFragment.newInstance())
            .add(R.id.fragment_container2, AccountFragment.newInstance())
            .commit()

        initViews()

    }

    fun initViews() {
        bottomNav = bottom_nav

        bottomNav.setOnNavigationItemSelectedListener(this)
    }


}
