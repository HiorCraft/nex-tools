package de.hiorcraft.nex.nextools.command.minecraft

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import org.bukkit.Bukkit

fun listCommand() = commandTree("list") {
    withPermission(PermissionRegistry.COMMAND_LIST)
    anyExecutor { executor, _ ->
        val onlinePlayers = Bukkit.getOnlinePlayers()
        val maxCount = Bukkit.getMaxPlayers()

        if (onlinePlayers.isEmpty()) {
            executor.sendText {
                appendInfoPrefix()
                info("Es sind keine Spieler online.)")
            }
            return@anyExecutor
        }

        executor.sendText {
            appendInfoPrefix()
            info("Es sind aktuell ")
            variableValue(onlinePlayers.size)
            info(" von ")
            variableValue(maxCount)
            info(" Spielern online.")
        }
    }

}