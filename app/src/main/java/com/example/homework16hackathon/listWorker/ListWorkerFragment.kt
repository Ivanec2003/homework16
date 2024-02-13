package com.example.homework16hackathon.listWorker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework16hackathon.detail.DetailWorkerFragment
import com.example.homework16hackathon.MyAdapter
import com.example.homework16hackathon.R
import com.example.homework16hackathon.Worker
import com.example.homework16hackathon.databinding.FragmentListWorkerBinding
import com.example.homework16hackathon.login.LoginFragment

class ListWorkerFragment : Fragment(), ListWorkerContract.View {
    private lateinit var presenter: ListWorkerPresenter
    private var _binding: FragmentListWorkerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListWorkerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ListWorkerPresenter(this, ListWorkerModel())
        binding.recyclerViewListWorker.layoutManager = LinearLayoutManager(requireContext())
        presenter.onViewCreated()
        clickBackToolbarNavigation()
    }

    override fun showList(listWorker: List<Worker>) {
        val adapter = MyAdapter(listWorker) { worker ->
            presenter.clickOnItemList(worker)
        }
        binding.recyclerViewListWorker.adapter = adapter
    }

    override fun navigateToDetailWorker(worker: Worker) {
        val fragment = DetailWorkerFragment().apply {
            arguments = Bundle().apply {
                putParcelable("worker", worker)
            }
        }
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("listWorker")
            .commit()
    }
    private fun clickBackToolbarNavigation(){
        binding.toolbarListWorker.setNavigationOnClickListener{
            presenter.clickBackToolbarNavigation()
        }
    }

    override fun goBackNavigation() {
        val fragment = LoginFragment()
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}