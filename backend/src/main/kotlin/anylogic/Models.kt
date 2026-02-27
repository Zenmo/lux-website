package anylogic

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object Models : Table("models") {
    val uuid = uuid("uuid")
    val lastModifiedDate = timestamp("last_modified_date")

    override val primaryKey = PrimaryKey(uuid)
}