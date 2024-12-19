package com.example.futportuguese.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.futportuguese.databinding.JogoItemBinding
import com.example.futportuguese.model.Jogos

class ListaDeJogosAdapter(
    private val context: Context,
    jogos: List<Jogos>
) : RecyclerView.Adapter<ListaDeJogosAdapter.ViewHolder>() {

    private val jogos = jogos.toMutableList()

    class ViewHolder(private val binding: JogoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun vincula(jogos: Jogos) {
            binding.jogoItemNomeDoOrganizador.text = jogos.nomeDoOrganizador
            binding.jogoItemNumeroParaContato.text = jogos.numeroParaContato
            binding.jogoItemDiaDoJogo.text = jogos.diaDaSemana
            binding.jogoItemHorarioDoInicioDoJogo.text = jogos.horarioDoInicioDoJogo
            binding.jogoItemHorarioDeFimDoJogo.text = jogos.horarioDoFimDoJogo
            binding.jogoItemValorParaPagar.text = jogos.valorDoJogo.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = JogoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
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
