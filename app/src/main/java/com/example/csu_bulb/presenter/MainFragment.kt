package com.example.csu_bulb.presenter

import androidx.fragment.app.Fragment
import com.example.csu_bulb.R
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.csu_bulb.databinding.FragmentMainBinding
import dev.androidbroadcast.vbpd.viewBinding
import com.example.csu_bulb.di.ViewModelFactory
import com.example.csu_bulb.di.appComponent
import javax.inject.Inject
import android.widget.ArrayAdapter
import android.widget.AdapterView
import com.example.csu_bulb.UiState
import android.widget.SeekBar



class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels() { viewModelFactory }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToggleBulb.setOnClickListener {
            viewModel.toggleBulb()
        }
        binding.seekBarBulbBrightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    viewModel.setBrightness(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit
            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit
        })

        viewModel.availableColors.observe(viewLifecycleOwner) { colors ->
            if (colors.isNotEmpty()) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, colors)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerColor.adapter = adapter

                viewModel.selectedColor.observe(viewLifecycleOwner) { selected ->
                    val position = colors.indexOfFirst { it == selected }
                    if (position != -1) {
                        binding.spinnerColor.setSelection(position)
                    }
                }
            }
        }

        binding.spinnerColor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedColor = parent.getItemAtPosition(position) as? String
                selectedColor?.let {
                    viewModel.setColor(it)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) = Unit
        }
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

}