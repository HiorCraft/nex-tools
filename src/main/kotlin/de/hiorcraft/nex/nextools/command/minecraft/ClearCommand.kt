package de.hiorcraft.nex.nextools.command.minecraft

import de.hiorcraft.nex.nextools.permisssions.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import io.papermc.paper.command.brigadier.argument.ArgumentTypes.player


fun clearCommand() = commandTree("clear") {
    withPermission(PermissionRegistry.COMMAND_CLEAR)
    playerExecutor { player, _ ->
        if (player.inventory.isEmpty) {
            player.sendText {
                appendPrefix()
                error("Dein Inventar ist bereits leer.")
            }
            return@playerExecutor

        }

        player.inventory.clear()

        player.sendText {
            appendPrefix()
            success("Dein Inventar wurde geleert.")
        }

    }
    entitySelectorArgumentOnePlayer("player") {
        withPermission(PermissionRegistry.COMMAND_CLEAR_OTHERS)
        anyExecutor { executor, args ->
            val player = args["player"] as org.bukkit.entity.Player

            if (player.inventory.isEmpty) {
                executor.sendText {
                    appendPrefix()
                    error("Das Inventar von ${player.name} ist bereits leer.")
                }
                return@anyExecutor
            }

            player.inventory.clear()

            executor.sendText {
                appendPrefix()
                success("Du hast das Inventar von ${player.name} geleert.")
            }

            player.sendText {
                appendPrefix()
                success("Dein Inventar wurde geleert.")
            }
        }
    }

}