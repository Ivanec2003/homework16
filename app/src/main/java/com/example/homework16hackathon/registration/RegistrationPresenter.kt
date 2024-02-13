package com.example.homework16hackathon.registration

class RegistrationPresenter(
    private val view: RegistrationContract.View,
    private val model: RegistrationContract.Model
): RegistrationContract.Presenter {
    override fun clickButtonRegistration(login: String, password: String, passwordRepeat: String){
        if (checkData(login, password, passwordRepeat)){
            model.saveUserData(login, password)
            view.navigateToHome()
        }
    }
    private fun checkData(login: String, password: String, passwordRepeat: String): Boolean{
        val checkLogin = login.any { !it.isUpperCase() }
        val checkPassword = password.length >= 6 && password == passwordRepeat
        return checkLogin && checkPassword
    }

}