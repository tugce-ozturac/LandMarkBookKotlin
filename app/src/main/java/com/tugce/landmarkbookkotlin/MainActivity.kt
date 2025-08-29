package com.tugce.landmarkbookkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.tugce.landmarkbookkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landMarkList : ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        landMarkList= ArrayList<Landmark>()

        val pisa = Landmark("pisa","italy", R.drawable.pisa)
        val colloseum = Landmark("Colloseum","Italy",R.drawable.colesseum)
        val eiffel = Landmark("Eiffel","France",R.drawable.eiffel)
        val londonBridge = Landmark("London Bridge","UK",R.drawable.london)

        landMarkList.add(pisa)
        landMarkList.add(colloseum)
        landMarkList.add(eiffel)
        landMarkList.add(londonBridge)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter(landMarkList)
        binding.recyclerView.adapter =landmarkAdapter


    }
}