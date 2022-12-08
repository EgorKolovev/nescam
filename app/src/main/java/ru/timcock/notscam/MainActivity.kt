package ru.timcock.notscam

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var  toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        toolBar=findViewById(R.id.tool_bar)
        setSupportActionBar(toolBar)


        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        toolBar.setNavigationOnClickListener{
            drawerLayout.open()

        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        replaceFragment(HomeFragment(), "crypto")

        navigationView.setNavigationItemSelectedListener {
            it.isChecked=true

            when(it.itemId){

                R.id.home_navigation_item-> replaceFragment(HomeFragment(), getString(R.string.home))

                R.id.courses_navigation_item-> replaceFragment(CoursesFragment(), getString(R.string.courses))

                R.id.contacts_navigation_item-> replaceFragment(ContactsFragment(), getString(R.string.contacts))

                R.id.profile_navigation_item-> replaceFragment(ProfileFragment(), getString(R.string.profile))

            }
            true

        }


    }
    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_home,fragment )
        fragmentTransaction.commit()
        toolBar.setTitle(title)
        drawerLayout.close()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage(R.string.are_you_sure_exit)
            .setCancelable(true)
            .setPositiveButton(R.string.yes, DialogInterface.OnClickListener { dialogInterface, i -> finish()  })
            .setNegativeButton(R.string.no, null)
            .show()
    }

}