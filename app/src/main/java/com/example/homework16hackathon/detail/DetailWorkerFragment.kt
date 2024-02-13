package com.example.homework16hackathon.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework16hackathon.ConfidenceLevel
import com.example.homework16hackathon.Worker
import com.example.homework16hackathon.databinding.FragmentDetailWorkerBinding

class DetailWorkerFragment : Fragment(), DetailWorkerContract.View {
    private lateinit var presenter: DetailWorkerPresenter
    private var worker: Worker? = null
    private var _binding: FragmentDetailWorkerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.let {
            worker = it.getParcelable("worker")
        }
        _binding = FragmentDetailWorkerBinding.inflate(inflater, container, false)
        clickBackToolbarNavigation()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = DetailWorkerPresenter(this)
        presenter.onViewCreated()
    }

    override fun showDetail() {
        val name = "Name: ${worker?.name}"
        val position = "Position: ${worker?.position}"
        val confidenceLevel = "Confidence level: ${worker?.confidenceLevel}"
        worker?.let { binding.imageViewPhotoWorkerDetail.setImageResource(it.image) }
        binding.textViewNameWorkerDetail.text = name
        binding.textViewPositionDetail.text = position
        val choseColorLevel = when(worker?.confidenceLevel){
            ConfidenceLevel.Low().level -> ConfidenceLevel.Low().valueColor
            ConfidenceLevel.Medium().level -> ConfidenceLevel.Medium().valueColor
            ConfidenceLevel.High().level -> ConfidenceLevel.High().valueColor
            else -> "${Color.BLACK}"
        }
        binding.textViewConfidenceLevelDetail.apply {
            text = confidenceLevel
            setTextColor(Color.parseColor(choseColorLevel))
            }
        }
    private fun clickBackToolbarNavigation(){
        binding.toolbarDetail.setNavigationOnClickListener{
            presenter.clickBackToolbarNavigation()
        }
    }

    override fun goBackNavigation() {
        parentFragmentManager.popBackStack()
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}