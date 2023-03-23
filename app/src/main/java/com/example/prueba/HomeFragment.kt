package com.example.prueba

import android.content.Context
import android.content.res.ColorStateList
import android.media.MediaPlayer
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.prueba.databinding.FragmentHomeBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.VideoView
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private val REQUEST_VIDEO_PICKER = 1
    private var player: SimpleExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnPlay.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_VIDEO_PICKER)
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        player = SimpleExoPlayer.Builder(requireContext()).build()
        binding.playerView.player = player

        val navView:BottomNavigationView = binding.bottomNavigation

        navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.externo -> replaceFragment()
            }
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        player?.release()
        player = null
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_VIDEO_PICKER && resultCode == Activity.RESULT_OK) {
            val videoUri = data?.data
            videoUri?.let {
                val mediaItem = MediaItem.fromUri(it)
                player?.setMediaItem(mediaItem)
                player?.prepare()
                player?.play()
            }
        }
    }

    fun replaceFragment(){
        findNavController().navigate(R.id.action_homeFragment_to_remoteFragment)
    }


    fun reproductor(context: Context){

    }
}