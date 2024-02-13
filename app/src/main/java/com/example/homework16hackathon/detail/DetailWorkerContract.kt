package com.example.homework16hackathon.detail

interface DetailWorkerContract {
    interface View{
        fun showDetail()
        fun goBackNavigation()
    }
    interface Presenter{
        fun onViewCreated()
        fun clickBackToolbarNavigation()
    }
}