package com.retech.myapplication.activity

import android.accounts.Account
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.internal.BottomNavigationMenu
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuInflater
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

    lateinit var sharedPrefs: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    val MY_SHARED_PREFS = "MY_APP_SHARED_PREFS"

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        Toast.makeText(this, "Clicked ${menuItem.title}", Toast.LENGTH_SHORT).show()

        val fragmentManager = supportFragmentManager.beginTransaction()

        // Default MainFragment
        var fragment: Fragment = MainFragment.newInstance()

        when (menuItem.itemId) {
            R.id.bottom_menu_main -> {
                fragment = MainFragment.newInstance()
                fragmentManager.setCustomAnimations(R.anim.slide_to_right, R.anim.slide_to_left)
            }
            R.id.bottom_menu_map -> fragment = PlusOneFragment.newInstance()
            R.id.bottom_menu_account -> {
                fragment = AccountFragment.newInstance()
                fragmentManager.setCustomAnimations(R.anim.slide_to_left, R.anim.slide_to_right)
            }
        }

        fragmentManager
                .replace(R.id.fragment_container, fragment, "MainFragment")
                .commit()

        return true
    }

    override fun onFragmentInteraction(uri: Uri) {

    }

    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sharedPrefs = getSharedPreferences(MY_SHARED_PREFS, Context.MODE_PRIVATE)
        editor = sharedPrefs.edit()

        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MainFragment.newInstance())
                .commit()

        initViews()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.main_menu_logout -> {

                editor.putBoolean("logged_in", false)
                        .commit()

                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        return true
    }

    fun initViews() {
        bottomNav = bottom_nav

        bottomNav.setOnNavigationItemSelectedListener(this)
    }


}
