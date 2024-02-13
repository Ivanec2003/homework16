package com.example.homework16hackathon.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework16hackathon.R
import com.example.homework16hackathon.databinding.FragmentRegistrationBinding
import com.example.homework16hackathon.listWorker.ListWorkerFragment

class RegistrationFragment : Fragment(), RegistrationContract.View {
    private lateinit var presenter: RegistrationPresenter

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = RegistrationPresenter(this, RegistrationModel())

        binding.buttonRegistration.setOnClickListener{
            val login = binding.textFieldEnterLoginRegistration.editText?.text.toString()
            val password = binding.textFieldEnterPasswordRegistration.editText?.text.toString()
            val passwordRepeat = binding.textFieldEnterPasswordRepeat.editText?.text.toString()
            presenter.clickButtonRegistration(login, password, passwordRepeat)
        }
    }


    override fun navigateToHome() {
        val fragment = ListWorkerFragment()
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