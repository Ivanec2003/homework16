package com.example.homework16hackathon

sealed class ConfidenceLevel(val level: String, val valueColor: String){
    class Low: ConfidenceLevel("Low", "#FF0000")//red
    class Medium: ConfidenceLevel("Medium", "#FFFF00")//yellow
    class High: ConfidenceLevel("High", "#00FF00")//green
}