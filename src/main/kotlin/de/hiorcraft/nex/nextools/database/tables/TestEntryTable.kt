package de.hiorcraft.nex.nextools.database.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object TestEntryTable : IntIdTable("waify_entries") {
    val playerUuid = uuid("player_uuid").uniqueIndex()
    val health = integer("health").default(20)
}