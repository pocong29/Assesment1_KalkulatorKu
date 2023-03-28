package org.d3if4063.kalkulatorku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import org.d3if4063.kalkulatorku.R
import org.d3if4063.kalkulatorku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { hitungLuas() }
        binding.button2.setOnClickListener { reset() }

    }

    private fun reset() {
        binding.editTextNumber.text.clear()
        binding.editTextNumber2.text.clear()
        binding.radioGroup.clearCheck()
        binding.hasilLuas.text = getString(R.string.luas_bangun)

    }

    private fun hitungLuas() {
        val panjang = binding.editTextNumber.text.toString()
        if (TextUtils.isEmpty(panjang)) {
            Toast.makeText(this, R.string.panjang_invalid, Toast.LENGTH_SHORT).show()
        }


        val lebar = binding.editTextNumber2.text.toString()
        if (TextUtils.isEmpty(lebar)) {
            Toast.makeText(this, R.string.lebar_invalid, Toast.LENGTH_SHORT).show()
        }

        if (!TextUtils.isEmpty(panjang) && !TextUtils.isEmpty(lebar)) {
            val hasilBangunDatar = panjang.toDouble() * lebar.toDouble()
            binding.hasilLuas.text = hasilBangunDatar.toString()
        }
    }
}