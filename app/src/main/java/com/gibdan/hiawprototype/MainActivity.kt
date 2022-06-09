package com.gibdan.hiawprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.gibdan.hiawprototype.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcvMain) as NavHostFragment
        val navController = navHostFragment.navController

        binding.btnBack.setOnClickListener {
            super.onBackPressed()
        }
        //var navController : NavController = Navigation.findNavController(this, R.id.fcvMain)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            //Log.e("", "onDestinationChanged: "+destination.label);
            binding.tvFrag.text = destination.label;
            if (destination.label == "fragment_home") {
                binding.btnBack.text = "Quit"
                binding.btnBack.setOnClickListener {
                    super.finish()
                }
            }
            else {
                binding.btnBack.text = "Back"
                binding.btnBack.setOnClickListener {
                    super.onBackPressed()
                }
            }
            //if (destination.label == "")

        }


        //var navController : NavController = Navigation.findNavController(this, R.id.nav_graph)

    }
}