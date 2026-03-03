package anylogic

import energy.lux.site.shared.AnyLogicModel
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class AnyLogicRepository(
    val db: Database = connectToAnyLogicPostgres()
) {
    fun getAllModels(): List<AnyLogicModel> {
        return transaction(db) {
            Models.selectAll()
                .where { Models.state eq "CREATED" }
                .map {
                    AnyLogicModel(
                        uuid = it[Models.uuid],
                        lastModifiedDate = it[Models.lastModifiedDate].toString(),
                    )
                }
        }
    }
}