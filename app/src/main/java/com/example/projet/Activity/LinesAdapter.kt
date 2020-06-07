package com.example.projet.Activity


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.R

import com.example.projet.service.Lines
import kotlinx.android.synthetic.main.ligne_view.view.*

class LinesAdapter (val lignes: List<Lines>) : RecyclerView.Adapter<LinesAdapter.LignesViewHolder>()
{

    class LignesViewHolder(val lignesView : View) : RecyclerView.ViewHolder(lignesView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LignesViewHolder {
        val layoutInfater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInfater.inflate(R.layout.ligne_view, parent, false)
        return LignesViewHolder(view)
    }

    override fun getItemCount(): Int  = lignes.size


    override fun onBindViewHolder(holder: LignesViewHolder, position: Int) {

        val prefs =
            PreferenceManager.getDefaultSharedPreferences(holder.lignesView.context)

        val order = prefs.getString("order_name", "1")?.toInt()

        val ligne = lignes[position]
        holder.lignesView.ligne_name_textview.text = "${ligne.name} ${ligne.directions} ${ligne.code}"


    }

}
