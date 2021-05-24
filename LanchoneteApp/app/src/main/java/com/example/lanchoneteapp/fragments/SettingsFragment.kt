package com.example.lanchoneteapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.View.inflate
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.lanchoneteapp.R
import com.example.lanchoneteapp.databinding.FragmentSettingsBinding
import kotlinx.android.synthetic.main.fragment_settings.*



class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!


    override fun onResume() {
        super.onResume()
        val languages = resources.getStringArray(R.array.languages)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, languages)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}