package org.d3if4063.kalkulatorku.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if4063.kalkulatorku.databinding.FragmentHasilBinding



class HasilFragment : Fragment() {
    private lateinit var binding: FragmentHasilBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentHasilBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}