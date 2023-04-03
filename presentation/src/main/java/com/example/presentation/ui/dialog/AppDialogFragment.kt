package com.example.presentation.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppDialogFragment : DialogFragment(R.layout.fragment_dialog) {
    private lateinit var binding: FragmentDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDialogBinding.inflate(layoutInflater)
        dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable = false
        return binding.root
    }
}