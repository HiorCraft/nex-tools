package de.hiorcraft.nex.nextools.command.minecraft

import de.hiorcraft.nex.nextools.permisssions.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import org.bukkit.entity.Player

fun healCommand() = commandTree("heal") {
    withPermission(PermissionRegistry.COMMAND_HEALTH)
    playerExecutor  { player , _ ->
        player.heal(10000.0)
        player.fireTicks = 0
        player.foodLevel = 20

        player.sendText {
            appendPrefix()
            success("Du wurdest geheilt.")
        }
    }

    entitySelectorArgumentOnePlayer("player") {
        withPermission(PermissionRegistry.COMMAND_HEALTH_OTHERS)
        anyExecutor { executor, args ->
            val player: Player = args["player"] as Player
            player.heal(10000.0)
            player.foodLevel = 20

            executor.sendText {
                appendPrefix()
                success("Du hast ${player.name} geheilt.")
            }

            player.sendText {
                appendPrefix()
                success("Du wurdest geheilt.")
            }
        }
    }
}