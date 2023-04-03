package com.example.presentation.ui.anime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.entity.FavoritesEntity
import com.example.presentation.databinding.FragmentAnimeBinding
import com.example.presentation.ui.dialog.AppDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment() {
    private lateinit var binding: FragmentAnimeBinding
    private val viewModel by viewModels<AnimeViewModel>()
    private val adapter by lazy { AnimeAdapter(::clickItem, ::clickFavorite) }
    private lateinit var dialog: AppDialogFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAnimeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog = AppDialogFragment()
        if (viewModel.animeList.isEmpty()) {
            liveDataObserve()
            viewModel.getAllAnime()
        }
        adapterInit()
        refreshLayout()
    }

    private fun liveDataObserve() {
        viewModel.animeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is AnimeUiState.Loading -> {
                    dialog.show(childFragmentManager, "dialogFragment")
                }
                is AnimeUiState.Success -> {
                    adapter.submitList(it.data)
                    dialog.dismiss()
                    binding.swiperefresh.isRefreshing = false
                }
                is AnimeUiState.Error -> {
                    Toast.makeText(requireContext(), "error ${it}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.addFavoriteState.observe(viewLifecycleOwner) {
            when (it) {
                is AddFavoriteAnimeUiState.Error -> {
                    Toast.makeText(requireContext(), "error add", Toast.LENGTH_SHORT).show()
                }
                is AddFavoriteAnimeUiState.Success -> {
                    Toast.makeText(
                        requireContext(),
                        "success add ${it.data.title}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is AddFavoriteAnimeUiState.Loading -> {
                    Toast.makeText(requireContext(), "loading..", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun adapterInit() {
        binding.animeRcv.adapter = adapter
        binding.animeRcv.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun clickItem(id: Int,isFavorite:Int) {
        val action = AnimeFragmentDirections.actionAnimeFragmentToAnimeDetailFragment(id,isFavorite)
        findNavController().navigate(action)
    }

    private fun clickFavorite(favoritesEntity: FavoritesEntity) {
        viewModel.addFavoriteAnime(favoritesEntity)
    }

    private fun refreshLayout() {
        binding.swiperefresh.setOnRefreshListener {
            viewModel.getAllAnime()
        }
    }


}


