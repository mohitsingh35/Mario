package com.ncs.marioapp.Domain.Models

data class UserSurvey(
    var name: String="",
    var admissionNum:String="",
    var branch:String="",
    var year:String="",
    var admitted_to:String="",
    var domains:List<String> = emptyList(),
    var links:List<String> = emptyList(),
    var userImg:String="",
    var collegeIdImg:String=""
)