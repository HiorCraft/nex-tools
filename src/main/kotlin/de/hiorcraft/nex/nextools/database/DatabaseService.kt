package de.hiorcraft.nex.nextools.database

import de.hiorcraft.nex.nextools.database.tables.TestEntryTable
import dev.slne.surf.database.DatabaseManager
import dev.slne.surf.database.database.DatabaseProvider
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.nio.file.Path

object DatabaseService {

    lateinit var databaseProvider: DatabaseProvider

    fun connect(path: Path) {
        databaseProvider = DatabaseManager(path, path).databaseProvider
        databaseProvider.connect()
    }

    fun disconnect() {
        databaseProvider.disconnect()
    }

    fun createTables() {
        transaction {
            SchemaUtils.create(TestEntryTable)
        }
    }
}