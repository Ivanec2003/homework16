package com.example.homework16hackathon.registration

interface RegistrationContract {
    interface View{
        fun navigateToHome()
    }
    interface Model{
        fun saveUserData(login: String, password: String)
    }
    interface Presenter{
        fun clickButtonRegistration(login: String, password: String, passwordRepeat: String)
    }
}