package com.example.homework16hackathon.listWorker

import com.example.homework16hackathon.Worker

interface ListWorkerContract {
    interface View{
        fun showList(listWorker: List<Worker>)
        fun navigateToDetailWorker(worker: Worker)
        fun goBackNavigation()
    }
    interface Model{
        fun getList(): List<Worker>
    }
    interface Presenter{
        fun clickOnItemList(worker: Worker)
        fun clickBackToolbarNavigation()
        fun onViewCreated()
    }
}