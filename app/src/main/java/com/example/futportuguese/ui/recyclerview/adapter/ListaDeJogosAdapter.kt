package com.example.futportuguese.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.futportuguese.R
import com.example.futportuguese.model.Jogos

class ListaDeJogosAdapter(
    private val context: Context,
    jogos: List<Jogos>
) : RecyclerView.Adapter<ListaDeJogosAdapter.ViewHolder>() {

    private val jogos = jogos.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(jogos: Jogos) {
            val nomeDoOrganizador = itemView.findViewById<TextView>(R.id.jogo_item_nomeDoOrganizador)
            nomeDoOrganizador.text = jogos.nomeDoOrganizador
            val numeroParaContato = itemView.findViewById<TextView>(R.id.jogo_item_numeroParaContato)
            numeroParaContato.text = jogos.numeroParaContato
            val diaDoJogo = itemView.findViewById<TextView>(R.id.jogo_item_diaDoJogo)
            diaDoJogo.text = jogos.diaDaSemana
            val horarioDoJogo = itemView.findViewById<TextView>(R.id.jogo_item_horarioDoInicioDoJogo)
            horarioDoJogo.text = jogos.horarioDoInicioDoJogo
            val horarioDoFimDoJogo = itemView.findViewById<TextView>(R.id.jogo_item_horarioDeFimDoJogo)
            horarioDoFimDoJogo.text = jogos.horarioDoFimDoJogo
            val valorDoJogo = itemView.findViewById<TextView>(R.id.jogo_item_valorParaPagar)
            valorDoJogo.text = jogos.valorDoJogo.toPlainString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.jogo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jogo = jogos[position]
        holder.vincula(jogo)
    }

    override fun getItemCount(): Int = jogos.size
    fun atualiza(jogos: List<Jogos>) {
        this.jogos.clear()
        this.jogos.addAll(jogos)
        notifyDataSetChanged()
    }

}
