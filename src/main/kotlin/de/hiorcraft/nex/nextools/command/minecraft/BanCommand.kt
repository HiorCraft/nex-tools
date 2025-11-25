package de.hiorcraft.nex.nextools.command.minecraft

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.getValue
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import org.bukkit.entity.Player

fun BanCommand() = commandAPICommand("ban") {
    withPermission(PermissionRegistry.COMMAND_BAN)

    anyExecutor { executor, _ ->
        executor.sendText {
            appendPrefix()
            error("Der Ban-Befehl wurde deaktiviert.")
        }
    }

    entitySelectorArgumentOnePlayer("player") {
        anyExecutor { executor, args ->
            val player: Player by args
            executor.sendText {
                appendPrefix()
                error("Der Ban-Befehl wurde deaktiviert.")
            }
        }
    }
}