package com.example.homework16hackathon

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val listWorker: List<Worker>,
    private val onItemClick: (Worker) -> Unit
): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_worker, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val worker = listWorker[position]
        holder.bind(worker, onItemClick)

    }

    override fun getItemCount(): Int {
        return listWorker.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageViewPhotoWorker: ImageView = itemView.findViewById(R.id.imageViewPhotoWorker)
        private val textViewNameWorker: TextView = itemView.findViewById(R.id.textViewNameWorker)
        private val textViewPosition: TextView = itemView.findViewById(R.id.textViewPosition)
        private val textViewConfidenceLevel: TextView = itemView.findViewById(R.id.textViewConfidenceLevel)
        fun bind(worker: Worker, onItemClick: (Worker) -> Unit){
            val name = "Name: ${worker.name}"
            val position = "Position: ${worker.position}"
            val confidenceLevel = "Confidence level: ${worker.confidenceLevel}"
            imageViewPhotoWorker.setImageResource(worker.image)
            textViewNameWorker.text = name
            textViewPosition.text = position

            val choseColor = when(worker.confidenceLevel){
                ConfidenceLevel.Low().level -> ConfidenceLevel.Low().valueColor
                ConfidenceLevel.Medium().level -> ConfidenceLevel.Medium().valueColor
                ConfidenceLevel.High().level -> ConfidenceLevel.High().valueColor
                else ->"${Color.BLACK}"
            }
            textViewConfidenceLevel.apply {
                text = confidenceLevel
                setTextColor(Color.parseColor(choseColor))
            }

            itemView.setOnClickListener {
                onItemClick(worker)
            }
        }
    }
}