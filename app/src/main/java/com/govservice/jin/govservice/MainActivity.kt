package com.govservice.jin.govservice

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.*
import android.widget.ImageView
//import com.govservice.jin.govservice.R.id.fab
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.recyclerview_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        Log.d("mainActivity", "mainAcitivty")
        recyclerView_main.adapter = MainRecyclerViewAdapter()
        recyclerView_main.layoutManager = GridLayoutManager(this, 3)

/*        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
*/
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    //상단 액션바의 검색창 동작
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)

        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener ( object : SearchView.OnQueryTextListener{

            override fun onQueryTextChange(newText: String) : Boolean {
                return false
            }
            override fun onQueryTextSubmit(query: String) : Boolean {
                //task here
                return false
            }
        })
        return true
    }

    //상단 액션바의 검색창
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.menu_search -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //좌측 슬라이드 네비게이션바
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_setting -> {
                // Handle the camera action
            }
            R.id.nav_scrap -> {

            }
            R.id.nav_keywords -> {

            }
            R.id.nav_logout -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    //메인메뉴
    class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        var images = arrayOf(R.drawable.ic_subject_leisure,
                        R.drawable.ic_subject_service,
                        R.drawable.ic_subject_car,
                        R.drawable.ic_subject_briefcase,
                        R.drawable.ic_subject_charity,
                        R.drawable.ic_subject_disaster,
                        R.drawable.ic_subject_house,
                        R.drawable.ic_subject_illegal,
                        R.drawable.ic_subject_lawfinance,
                        R.drawable.ic_subject_life,
                        R.drawable.ic_subject_management,
                        R.drawable.ic_subject_stroller
                )

        //각각의 아이템에 데이터 바인딩
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            val view = holder as CustomViewHoler
            view!!.imageview!!.setImageResource(images[position])

        }
        //각각의 아이템의 디자인 레이아웃 호출
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_layout, parent, false)
            var params = view.layoutParams
            params.height = parent.measuredWidth / 3
            params.width = parent.measuredWidth / 3
            view.layoutParams = params
            return CustomViewHoler(view)
        }

        class CustomViewHoler(view: View?) : RecyclerView.ViewHolder(view) {
            var imageview : ImageView? =null
            init{
                imageview = view!!.findViewById(R.id.layoutItem_imageview)
            }
        }

        //아이템 갯수 카운터
        override fun getItemCount(): Int {
            return images.size
        }
    }
}
