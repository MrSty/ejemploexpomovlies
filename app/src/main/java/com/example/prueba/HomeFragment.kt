package com.example.prueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.prueba.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navView:BottomNavigationView = binding.bottomNavigation

        navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.interno -> Toast.makeText(context, "Ya estas en dicho sitio", Toast.LENGTH_SHORT).show()
                R.id.externo -> replaceFragment()
            }
            true
        }
    }

    fun replaceFragment(){
        findNavController().navigate(R.id.action_homeFragment_to_remoteFragment)
    }

}