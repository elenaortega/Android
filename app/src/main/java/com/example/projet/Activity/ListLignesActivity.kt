package com.example.projet.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projet.R
import com.example.projet.data.MetroDao
import com.example.projet.model.Lignes
import com.example.projet.service.LinesService
import kotlinx.android.synthetic.main.activity_liste_lignes.*
import kotlinx.coroutines.runBlocking

class ListLignesActivity : AppCompatActivity() {

    private var metroDao : MetroDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_lignes)

        lignes_recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        metroDao = dao()
    }


    override fun onResume() {
        super.onResume()
        runBlocking {
            val lignes  = metroDao?.getLines()
            lignes_recyclerview.adapter = LinesAdapter(lignes ?: emptyList())
        }
    }

    /**
     * Ajouter le Menu
     *
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_bar,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem) : Boolean =
        when(item.itemId){
            R.id.action_favs -> {
                val intent = Intent(this, FavorisActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_synchro ->{
                synchroServer()
                true
            }
            else -> onOptionsItemSelected(item)
        }


    private fun synchroServer() {
        val service = retrofit().create(LinesService::class.java)
        runBlocking {
            val result = service.getLines(20, "metros")
            result.results.map {
                val ligne = Lignes(0, it.code, it.name, it.directions,it.num.id, true)
                metroDao?.addLignes(lignes)
            }
            val lignes = metroDao?.getLines()
            lignes_recyclerview.adapter = LinesAdapter(lignes ?: emptyList())
        }

    }

}
