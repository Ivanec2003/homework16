package com.example.homework16hackathon.detail

class DetailWorkerPresenter(
    private val view: DetailWorkerContract.View
): DetailWorkerContract.Presenter {
    override fun onViewCreated() {
        view.showDetail()
    }

    override fun clickBackToolbarNavigation() {
        view.goBackNavigation()
    }
}