package com.learningkotlin.avengers.application.web.request

import com.learningkotlin.avengers.domain.avenger.Avenger
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class AvengerRequest(

    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val nick: String,

    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val person: String,
    val description: String? = "",
    val history: String? = ""
) {
    fun toAvenger() = Avenger(
        nick = nick,
        person = person,
        description = description,
        history = history
    )

    companion object {
        fun to(id: Long?, request: AvengerRequest) = Avenger(
                id = id,
                nick = request.nick,
                person = request.person,
                description = request.description,
                history = request.history
        )
    }
}