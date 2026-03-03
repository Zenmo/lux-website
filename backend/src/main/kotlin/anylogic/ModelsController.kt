package com.zenmo.backend.anylogic

import anylogic.AnyLogicRepository
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.Status.Companion.OK
import org.http4k.format.Jackson.json

class ModelsController(
    private val repository: AnyLogicRepository = AnyLogicRepository()
) {
    fun handler(request: Request): Response {
        return try {
            val response = repository.getAllModels()
            Response(OK).json(response)
        } catch (e: Exception) {
            Response(Status.INTERNAL_SERVER_ERROR).body("Failed to fetch models: ${e.message}")
        }
    }
}