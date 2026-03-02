package anylogic

import com.zenmo.backend.getEnvRequired
import org.jetbrains.exposed.sql.Database
import org.postgresql.Driver

fun connectToAnyLogicPostgres(): Database {
    val url = getEnvRequired("ANYLOGIC_POSTGRES_URL")
    val user = getEnvRequired("ANYLOGIC_POSTGRES_USER")
    val password = getEnvRequired("ANYLOGIC_POSTGRES_PASSWORD")

    return connectToPostgres(url, user, password)
}

fun connectToPostgres(url: String, user: String, password: String): Database =
    Database.connect(url, driver = Driver::class.qualifiedName!!, user, password)