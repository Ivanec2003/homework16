package com.example.homework16hackathon.listWorker

import com.example.homework16hackathon.Worker

class ListWorkerPresenter(
    private val view: ListWorkerFragment,
    private val model: ListWorkerContract.Model
): ListWorkerContract.Presenter {

    override fun clickOnItemList(worker: Worker) {
        view.navigateToDetailWorker(worker)
    }

    override fun clickBackToolbarNavigation() {
        view.goBackNavigation()
    }

    override fun onViewCreated() {
        view.showList(model.getList())
    }
}