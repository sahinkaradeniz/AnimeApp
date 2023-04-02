package com.example.presentation.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.entity.FavoritesEntity
import com.example.presentation.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {


    private val viewModel by viewModels<FavoritesViewModel>()
    private val adapter by lazy { FavoritesAdapter(::deleteButtonClick) }
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
        binding= FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcvFavorites.adapter=adapter
        binding.rcvFavorites.layoutManager=GridLayoutManager(requireContext(),2)
        observeLiveData()
        viewModel.getFavoritesList()
    }


    private fun observeLiveData() {
        viewModel.favoritesListState.observe(viewLifecycleOwner) {
            when(it){
                is FavoritesUiState.Error ->{
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is FavoritesUiState.Success ->{
                    adapter.submitList(it.data)
                }
                is FavoritesUiState.Loading ->{

                }
            }
        }
        viewModel.deleteFavoriteState.observe(viewLifecycleOwner){
            when(it){
                is DeleteFavoritesUiState.Error ->{
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is DeleteFavoritesUiState.Success ->{
                    Toast.makeText(requireContext(), "favorite deleted", Toast.LENGTH_SHORT).show()
                }
                is DeleteFavoritesUiState.Loading ->{

                }
            }
        }
    }
    private fun deleteButtonClick(favoritesEntity: FavoritesEntity) {
        viewModel.deleteFromFavorite(favoritesEntity)
    }


}