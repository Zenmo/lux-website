package anylogic

import com.zenmo.backend.getEnvRequired
import org.jetbrains.exposed.sql.Database
import org.postgresql.Driver

fun connectToAnyLogicPostgres(): Database {
    val url = getEnvRequired("POSTGRES_URL")
    val user = getEnvRequired("POSTGRES_USER")
    val password = getEnvRequired("POSTGRES_PASSWORD")

    return connectToPostgres(url, user, password)
}

fun connectToPostgres(url: String, user: String, password: String): Database =
    Database.connect(url, driver = Driver::class.qualifiedName!!, user, password)