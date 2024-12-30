package com.example.futportuguese.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.futportuguese.databinding.JogoItemBinding
import com.example.futportuguese.extensions.tentaCarregarImagem
import com.example.futportuguese.model.Jogos
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

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
            val valorEmMoeda: String = formataParaMoedaBrasileira(jogos.valorDoJogo)
            binding.jogoItemValorParaPagar.text = valorEmMoeda


            /* val visibilidade = if(jogos.imagem != null) {     *Outro meio de implmentar o "Error" da imagem*
                View.VISIBLE
            } else {
                View.INVISIBLE
            }
            binding.imageView.visibility = visibilidade
            */


            binding.imageView.tentaCarregarImagem(jogos.imagem)
        }

        private fun formataParaMoedaBrasileira(jogos: BigDecimal): String {
            val formatador: NumberFormat = NumberFormat
                .getCurrencyInstance(Locale("pt", "br"))
            val valorEmMoeda: String = formatador.format(jogos)
            return valorEmMoeda
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



/*
 o Adapter é uma classe que serve para conectar dados de uma fonte,
 como uma lista ou banco de dados, com um componente de interface do usuário,
 como uma RecyclerView ou ListView. Ele basicamente "adapta" os dados para um formato que a visualização possa exibir.
 */