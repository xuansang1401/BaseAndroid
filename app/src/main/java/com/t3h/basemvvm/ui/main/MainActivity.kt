package com.t3h.basemvvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.t3h.basemvvm.R
import com.t3h.basemvvm.data.model.db.HistoryModel
import com.t3h.basemvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private  val viewModel: MainViewModel by viewModels()
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            val id= binding.edId.text.toString().trim()
            val name  = binding.edName.text.toString().trim()
            viewModel.addData(HistoryModel(id,name,Date().time))
        }
        getAll()
    }
    private fun getAll(){
        viewModel.getAll().observe(this, androidx.lifecycle.Observer {
            var s: String=""
            for (i in it){
                s+="Data: $i  \n"
            }
            binding.tv1.text=s
        })
    }
}