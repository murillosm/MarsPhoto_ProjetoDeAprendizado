
package com.example.android.marsphotos.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android.marsphotos.databinding.FragmentOverviewBinding

/**
 * Este fragmento mostra o status da transação de serviços da Web de fotos de Marte.
 */
class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    //Infla o layout com Data Binding, define seu proprietário do ciclo de vida para o OverviewFragment
    //para habilitar o Data Binding para observar o LiveData e configurar o RecyclerView com um adaptador.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        // Permite vinculação de dados para observar LiveData com o ciclo de vida deste Fragment
        binding.lifecycleOwner = this

        // Dando o acesso de ligação ao OverviewViewModel
        binding.viewModel = viewModel

        // Define o adaptador do photosGrid RecyclerView
        binding.photosGrid.adapter = PhotoGridAdapter()

        return binding.root
    }
}
