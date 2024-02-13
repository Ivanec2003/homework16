package com.example.homework16hackathon.registration

import com.example.homework16hackathon.UserData

class RegistrationModel : RegistrationContract.Model {
    override fun saveUserData(login: String, password: String){
        UserData.login = login
        UserData.password = password
    }

}