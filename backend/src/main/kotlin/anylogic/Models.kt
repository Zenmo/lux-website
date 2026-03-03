package anylogic

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object Models : Table("models") {
    val uuid = text("uuid")
    val lastModifiedDate = timestamp("last_modified_date")
    val state = text("state")

    override val primaryKey = PrimaryKey(uuid)
}