package com.example.thirdapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thirdapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var numbers = 0

        binding.text.text = numbers.toString()
        binding.root.setBackgroundColor(Color.BLUE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.plusButton.setOnClickListener {
            if (numbers < 10) {
                numbers += 1
                binding.text.text = numbers.toString()
            }
            if (numbers == 10) {
                binding.root.setBackgroundColor(Color.RED)
            }
        }
        binding.resetButton.setOnClickListener {
            numbers = 0
            binding.text.text = numbers.toString()
            binding.root.setBackgroundColor(Color.BLUE)
        }

    }
}