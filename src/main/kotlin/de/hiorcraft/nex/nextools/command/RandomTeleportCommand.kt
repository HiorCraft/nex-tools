package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import org.bukkit.Bukkit

fun teleportRandomCommand() = commandTree("teleportrandom") {
    withAliases("tpr")
    withPermission(PermissionRegistry.TELEPORT_RANDOM_COMMAN)

    playerExecutor { player, _ ->
        val selected = Bukkit.getOnlinePlayers()
            .randomOrNull() ?: run {
            player.sendText {
                appendErrorPrefix()
                error("Es wurde kein Spieler gefunden, zu dem du teleportiert werden kannst.")
            }
            return@playerExecutor
        }

        player.teleportAsync(selected.location)
        player.sendText {
            appendSuccessPrefix()
            success("Du wurdest zu ")
            variableValue(selected.name)
            success(" teleportiert.")
        }
    }
}