package com.example.prueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.prueba.databinding.FragmentImgBinding
import org.json.JSONArray
import org.json.JSONObject


class ImgFragment : Fragment() {

private lateinit var binding: FragmentImgBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImgBinding.inflate(layoutInflater)
      return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagen = binding.image
        val queue = Volley.newRequestQueue(getActivity())
        val url = "acaba va tu puta direccion de mierda"
        val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener { response ->
            val jsonArray = JSONArray(response)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = JSONObject(jsonArray.getString(i))
                Glide.with(requireActivity()).load(jsonObject.get("ruta").toString()).into(imagen)

            }
        },Response.ErrorListener { error ->


        })
        queue.add(stringRequest)
    }


}