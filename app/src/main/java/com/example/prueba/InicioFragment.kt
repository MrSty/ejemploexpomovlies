package com.example.prueba

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prueba.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {
    lateinit var binding: FragmentInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
   binding = FragmentInicioBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFoto.setOnClickListener { findNavController().navigate(R.id.action_inicioFragment_to_fotoFragment) }

        binding.btnReproRemota.setOnClickListener { findNavController().navigate(R.id.action_inicioFragment_to_homeFragment)}

        binding.btnFotoRemota.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_imgFragment)

        }


    }


}