package com.example.projet.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.projet.R

class HomeFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}
