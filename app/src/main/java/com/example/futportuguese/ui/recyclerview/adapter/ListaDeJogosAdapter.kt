package com.example.futportuguese.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.futportuguese.databinding.JogoItemBinding
import com.example.futportuguese.extensions.formataParaMoedaBrasileira
import com.example.futportuguese.extensions.tentaCarregarImagem
import com.example.futportuguese.model.Jogos

class ListaDeJogosAdapter(
    private val context: Context,
    jogos: List<Jogos> = emptyList(),

    var quandoClicaNoItem: (jogo: Jogos) -> Unit = {}
) : RecyclerView.Adapter<ListaDeJogosAdapter.ViewHolder>() {

    private val jogos = jogos.toMutableList()


    inner class ViewHolder(private val binding: JogoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var jogos: Jogos

        init {
            // implementação do listener do adapter
            itemView.setOnClickListener {
                // verificação da existência de valores em property lateinit
                if (::jogos.isInitialized) {
                    quandoClicaNoItem(jogos)
                }
            }
        }

        fun vincula(jogo: Jogos) {
            this.jogos = jogo
            val nomeDoOrganizador = binding.jogoItemNomeDoOrganizador
            nomeDoOrganizador.text = jogos.nomeDoOrganizador
            val numeroParaContato = binding.jogoItemNumeroParaContato
            numeroParaContato.text = jogos.numeroParaContato
            val diaDoJogo = binding.jogoItemDiaDoJogo
            diaDoJogo.text = jogos.diaDaSemana
            val inicioDoJogo = binding.jogoItemHorarioDoInicioDoJogo
            inicioDoJogo.text = jogos.horarioDoInicioDoJogo
            val fimDoJogo = binding.jogoItemHorarioDeFimDoJogo
            fimDoJogo.text = jogos.horarioDoFimDoJogo
            val valor = binding.jogoItemValorParaPagar
            val valorEmMoeda: String = jogos.valorDoJogo
                .formataParaMoedaBrasileira()
            valor.text = valorEmMoeda

            val visibilidade = if (jogos.imagem != null) {
                View.VISIBLE
            } else {
                View.GONE
            }

            binding.imageView.visibility = visibilidade


            binding.imageView.tentaCarregarImagem(jogos.imagem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = JogoItemBinding.inflate(inflater, parent, false)
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


/*
 o Adapter é uma classe que serve para conectar dados de uma fonte,
 como uma lista ou banco de dados, com um componente de interface do usuário,
 como uma RecyclerView ou ListView. Ele basicamente "adapta" os dados para um formato que a visualização possa exibir.
 */