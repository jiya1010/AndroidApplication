package com.example.androidapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.nit3213.data.DashboardResponse
import com.example.androidapplication.presentation.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardScreen : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private var recyclerView:RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView=findViewById(R.id.recyclerview)
        userViewModel.getDashboardData()

        userViewModel.dashboard.observe(this){
            Log.wtf("observer","$it")
            setupData(it)
        }

    }

    private fun setupData(dashboardResponse: DashboardResponse) {
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val entityAdapter=EntityAdapter(dashboardResponse.entities){
            Constants.clickedData=it
            startActivity(Intent(this,EntityDetailActivity::class.java))
        }
        recyclerView?.adapter=entityAdapter
    }
}