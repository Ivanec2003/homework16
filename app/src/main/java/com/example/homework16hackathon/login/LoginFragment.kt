package com.example.homework16hackathon.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework16hackathon.R
import com.example.homework16hackathon.UserData
import com.example.homework16hackathon.listWorker.ListWorkerFragment


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkLoginPassword()
    }
    private fun checkLoginPassword(){
        if(UserData.login.isNotEmpty() && UserData.password.isNotEmpty())
        {
            val fragment = ListWorkerFragment()
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack("")
                .commit()
        }
    }
}