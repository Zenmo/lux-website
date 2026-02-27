package anylogic

import energy.lux.site.shared.AnyLogicModel
import kotlinx.datetime.toJavaInstant
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.time.toKotlinInstant
import kotlin.uuid.toKotlinUuid

class AnyLogicRepository(
    val db: Database = connectToAnyLogicPostgres()
) {
    fun getAllModels(): List<AnyLogicModel> {
        return transaction(db) {
            Models.selectAll()
                .map {
                    AnyLogicModel(
                        uuid = it[Models.uuid].toKotlinUuid(),
                        lastModifiedDate = it[Models.lastModifiedDate]
                            .toJavaInstant()
                            .toKotlinInstant()
                    )
                }
        }
    }
}