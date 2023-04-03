package com.example.presentation.ui.animedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.common.extension.downloadFromUrl
import com.example.presentation.R
import com.example.presentation.databinding.FragmentAnimeDetailBinding
import com.example.presentation.ui.dialog.AppDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : Fragment() {

    private val viewModel by viewModels<AnimeDetailViewModel>()
    private lateinit var binding: FragmentAnimeDetailBinding
    private val args: AnimeDetailFragmentArgs by navArgs()
    private lateinit var dialog:AppDialogFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAnimeDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        dialog= AppDialogFragment()
        clickBackButtons()
        getArgs()
    }

    private fun observeLiveData() {
        viewModel.animeDetailState.observe(viewLifecycleOwner) {
            when(it) {
                is AnimeDetailUiState.Error -> {
                    binding.erorDetailAnime.text = requireContext().getText(R.string.eror)
                    dialog.dismiss()
                }
                is AnimeDetailUiState.Success -> {
                    setData(it.data)
                    dialog.dismiss()
                }
                is AnimeDetailUiState.Loading -> {
                    dialog.show(childFragmentManager,"dialogFragment")
                }
            }
        }
        viewModel.addFavoriteState.observe(viewLifecycleOwner){
            when(it){
                is AddFavoriteAnimeDetailUiState.Error ->{
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is AddFavoriteAnimeDetailUiState.Success ->{
                    binding.addfavoriteButton.setImageResource(R.drawable.baseline_favorite_24)
                }
                is AddFavoriteAnimeDetailUiState.Loading ->{

                }
            }
        }
    }

    private fun setData(animeDetailUiData: AnimeDetailUiData) {
        binding.apply {
            animeDetailTitle.text = animeDetailUiData.titleEnglish
            animeDesc.text = animeDetailUiData.background
            animeScore.text = animeDetailUiData.score.toString()
            animeDetailImage.downloadFromUrl(animeDetailUiData.images)
            brodDay.text = animeDetailUiData.day.toString()
            brodTime.text = animeDetailUiData.time.toString()
            brodTimezone.text = animeDetailUiData.timezone.toString()
        }
    }

    private fun clickBackButtons() {
        binding.backButtonAnime.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.addfavoriteButton.setOnClickListener {
            viewModel.addAnimeToFavorites()
        }
    }
    private fun getArgs(){
        val id = args.id
        viewModel.getAnimeDetail(id)
        val isFavorite=args.isFavorite
        if (isFavorite==1){
            binding.addfavoriteButton.setImageResource(R.drawable.baseline_favorite_24)
        }else{
            binding.addfavoriteButton.setImageResource(R.drawable.ic_empty_favorite)
        }
    }
}