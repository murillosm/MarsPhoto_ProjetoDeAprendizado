package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

//Esta classe implementa um [RecyclerView] [ListAdapter] que usa Data Binding para apresentar [List]
//dados, incluindo diferenças de computação entre listas.
class PhotoGridAdapter : ListAdapter<MarsPhoto, PhotoGridAdapter.MarsPhotosViewHolder>(DiffCallback)  {

    //O construtor MarsPhotosViewHolder pega a variável de ligação do associado
    //GridViewItem, que dá acesso a todas as informações [MarsPhoto].
    class MarsPhotosViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(marsPhoto: MarsPhoto) {
            binding.photo = marsPhoto
            // Isso é importante porque força a execução imediata da vinculação de dados,
            // que permite que o RecyclerView faça as medições corretas do tamanho da visualização
            binding.executePendingBindings()
        }
    }

    //Permite que o RecyclerView determine quais itens foram alterados quando a [Lista] de
    //[MarsPhoto] foi atualizado.
    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    //Crie novas exibições de itens [RecyclerView] (invocadas pelo gerenciador de layout)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotosViewHolder {
        return MarsPhotosViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    //Substitui o conteúdo de uma visualização (chamada pelo gerenciador de layout)
    override fun onBindViewHolder(holder: MarsPhotosViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }
}

