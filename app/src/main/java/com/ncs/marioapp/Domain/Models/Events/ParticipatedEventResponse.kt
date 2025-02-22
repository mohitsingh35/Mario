package com.ncs.marioapp.Domain.Models.Events

data class ParticipatedEventResponse(
    val success: Boolean,
    val message:String,
    val events: List<ParticipatedEvent>
)
