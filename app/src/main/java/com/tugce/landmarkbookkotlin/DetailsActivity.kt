package com.tugce.landmarkbookkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tugce.landmarkbookkotlin.databinding.ActivityDetailsBinding

private lateinit var binding: ActivityDetailsBinding
class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val landmark = intent.getSerializableExtra("landmark") as? Landmark
        landmark?.let { lm ->
            binding.nameText.text = lm.name
            binding.countryText.text = lm.country
            binding.imageView.setImageResource(lm.image)
        }
    }
}