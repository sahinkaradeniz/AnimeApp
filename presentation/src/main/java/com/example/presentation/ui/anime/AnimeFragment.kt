package com.example.presentation.ui.anime
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.common.extension.gone
import com.example.common.extension.visible
import com.example.domain.entity.FavoritesEntity
import com.example.presentation.databinding.FragmentAnimeBinding
import com.example.presentation.ui.animedetail.AddFavoriteAnimeDetailUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment() {
    private lateinit var binding:FragmentAnimeBinding
    private val viewModel by viewModels<AnimeViewModel>()
    private val adapter by lazy { AnimeAdapter(::clickItem,::clickFavorite) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentAnimeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        liveDataObserve()
        viewModel.getAllAnime()
        adapterInit()
    }

    private fun liveDataObserve() {
        viewModel.animeUiState.observe(viewLifecycleOwner){
            when(it){
                is AnimeUiState.Loading ->{
                    progressShow()
                }
                is AnimeUiState.Success ->{
                    handleUiState(it.data)
                    progressHide()
                }
                is AnimeUiState.Error ->{
                    Toast.makeText(requireContext(), "eror ${it}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.addFavoriteState.observe(viewLifecycleOwner){
            when(it){
                is AddFavoriteAnimeUiState.Error ->{
                    Toast.makeText(requireContext(), "eror add", Toast.LENGTH_SHORT).show()
                }
                is AddFavoriteAnimeUiState.Success ->{
                    Toast.makeText(requireContext(), "succes add ${it.data.title}", Toast.LENGTH_SHORT).show()
                }
                is AddFavoriteAnimeUiState.Loading ->{

                }
            }
        }
    }
    private fun adapterInit(){
        binding.animeRcv.adapter=adapter
        binding.animeRcv.layoutManager= GridLayoutManager(requireContext(), 2)
    }
    private fun clickItem(id: Int) {
        Toast.makeText(requireContext(), id.toString(), Toast.LENGTH_SHORT).show()
        val action =AnimeFragmentDirections.actionAnimeFragmentToAnimeDetailFragment(id)
        findNavController().navigate(action)
    }
    private fun clickFavorite(favoritesEntity: FavoritesEntity) {
        viewModel.addFavoriteAnime(favoritesEntity)
    }

    private fun handleUiState(data: List<AnimeUiData>) {
        adapter.submitList(data)
    }

    private fun progressShow() {
        binding.progressBar.visible()
        binding.animeRcv.gone()
    }

    private fun progressHide() {
        binding.progressBar.gone()
        binding.animeRcv.visible()
    }

}


