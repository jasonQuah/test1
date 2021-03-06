package com.example.test1

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_drawer_main.*

class navDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_drawer_main)

        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_Layout)

        val navigationview : NavigationView = findViewById(R.id.nav_view)
        navigationview.setNavigationItemSelectedListener(this)

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            (R.string.navigation_drawer_open),
            (R.string.navigation_drawer_close)) {}

        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, jobListFragment())
                .commit()
            navigationview.setCheckedItem(R.id.job_List_fragment)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.job_List_fragment -> {

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, jobListFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.about_JobSquare_fragment -> {

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, aboutFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.myProfile_fragment -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, profileFragment())
                    .commit()
            }
            R.id.myApplication_fragment -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, myApplicationFragment())
                    .commit()
            }
            R.id.saved_Jobs_fragment -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, favouriteFragment())
                    .commit()
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        } else{
            super.onBackPressed()
        }
    }
}