package com.example.prueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.prueba.databinding.FragmentRemoteBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class RemoteFragment : Fragment() {

    lateinit var binding:FragmentRemoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRemoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playerView = binding.playerView
        val player = context?.let { ExoPlayer.Builder(it).build() }

        val mediaItem: MediaItem = MediaItem.fromUri("http://10.20.28.217/prueba/upload/videoprueba.mp4")
        if (player != null) {
            player.setMediaItem(mediaItem)
        }
        if (player != null) {
            player.prepare()
        }
        if (player != null) {
            player.play()
        }

        playerView.player = player

        val navView: BottomNavigationView = binding.bottomNavigation
        navView.selectedItemId = R.id.externo

        navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.interno -> replaceFragment()
                R.id.externo -> Toast.makeText(context, "Item already selected", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
    fun replaceFragment(){
        findNavController().navigate(R.id.action_remoteFragment_to_homeFragment)
    }
}
