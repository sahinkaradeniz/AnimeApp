package com.example.presentation.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.data.dto.favorite.FavoritesDbModel
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
        viewModel.favoritesList.observe(viewLifecycleOwner) {
             adapter.submitList(it)
        }
    }
    private fun deleteButtonClick(favoritesEntity: FavoritesEntity) {
        viewModel.deleteFromFavorite(favoritesEntity)
    }


}