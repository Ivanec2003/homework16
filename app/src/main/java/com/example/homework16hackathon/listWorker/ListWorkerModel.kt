package com.example.homework16hackathon.listWorker

import com.example.homework16hackathon.R
import com.example.homework16hackathon.Worker

class ListWorkerModel: ListWorkerContract.Model {

    private val listWorker = mutableListOf(
        Worker( R.mipmap.ic_launcher, "Vlad", "Manager", "Medium"),
        Worker( R.mipmap.ic_launcher, "Max", "Manager", "Low"),
        Worker( R.mipmap.ic_launcher, "David", "Programmer", "High"),
        Worker( R.mipmap.ic_launcher, "Petro", "Programmer", "Medium"),
        Worker( R.mipmap.ic_launcher, "John", "Seller", "Medium"),
        Worker( R.mipmap.ic_launcher, "Den", "Programmer", "Low"),
        Worker( R.mipmap.ic_launcher, "Nik", "Manager", "Low"),
        Worker( R.mipmap.ic_launcher, "Alla", "Seller", "High"),)
    override fun getList(): List<Worker> {
        return listWorker
    }
}