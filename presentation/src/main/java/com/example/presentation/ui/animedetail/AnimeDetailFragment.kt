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
import com.example.common.extension.gone
import com.example.common.extension.visible
import com.example.presentation.R
import com.example.presentation.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : Fragment() {

    private val viewModel by viewModels<AnimeDetailViewModel>()
    private lateinit var binding: FragmentAnimeDetailBinding
    private val args: AnimeDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAnimeDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewState()
        getArgs()
        clickBackButton()

    }

    private fun viewState() {
        viewModel.animeDetailState.observe(viewLifecycleOwner) {
            when (it) {
                is AnimeDetailUiState.Error -> {
                    binding.erorDetailAnime.text = requireContext().getText(R.string.eror)
                    progressVisible()
                }
                is AnimeDetailUiState.Success -> {
                    setData(it.data)
                    progressGone()
                    clickFavoriteButton(it.data)
                }
                is AnimeDetailUiState.Loading -> {
                    binding.erorDetailAnime.text = requireContext().getText(R.string.loading)
                    progressVisible()
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

    private fun clickBackButton() {
        binding.backButtonAnime.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun clickFavoriteButton(animeDetailUiData: AnimeDetailUiData) {
        binding.favoriteDetailAnime.setOnClickListener {
            viewModel.addAnimeToFavorites(animeDetailUiData)
            Toast.makeText(requireContext(), "add anime to favorites", Toast.LENGTH_SHORT).show()
        }
    }

    private fun progressGone() {
        binding.rootView.visible()
        binding.animeDetailProgress.gone()
        binding.erorDetailAnime.gone()
    }

    private fun progressVisible() {
        binding.rootView.gone()
        binding.animeDetailProgress.visible()
        binding.erorDetailAnime.visible()
    }

    private fun getArgs() {
        val id = args.id
        viewModel.getAnimeDetail(id)
    }


}