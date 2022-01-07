package com.example.notetakingapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.notetakingapp.R
import com.example.notetakingapp.databinding.ActivityMainBinding

class HomeActvity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =   DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
}