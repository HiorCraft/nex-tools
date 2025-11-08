package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.permisssions.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import org.bukkit.entity.Player

fun hatCommand() = commandAPICommand("hat") {
    withPermission(PermissionRegistry.COMMAND_HAT)
    playerExecutor { player, _ ->
        val itemInHand = player.inventory.itemInMainHand
        player.inventory.helmet = itemInHand

        if (itemInHand.type.isAir) {
            player.sendText {
                appendPrefix()
                success("Du hast deinen Hut entfernt.")
            }
        } else {
            player.sendText {
                appendPrefix()
                success("Du hast deinen Hut gesetzt.")
            }
        }
    }
    entitySelectorArgumentOnePlayer("player") {
        withPermission(PermissionRegistry.COMMAND_HAT_OTHERS)
        playerExecutor { executor, args ->
            val player: Player = args["player"] as Player
            val itemInHand = executor.inventory.itemInMainHand
            player.inventory.helmet = itemInHand

            if (itemInHand.type.isAir) {
                executor.sendText {
                    appendPrefix()
                    variableValue(player.name)
                    success("s Hut wurde entfernt.")
                }
                player.sendText {
                    appendPrefix()
                    success("Dir wurde der Hut entfernt.")
                }
            } else {
                executor.sendText {
                    appendPrefix()
                    variableValue(player.name)
                    success("s Hut wurde gesetzt.")
                }
                player.sendText {
                    appendPrefix()
                    success("Dir wurde der Hut gesetzt.")
                }

            }
        }
    }
}