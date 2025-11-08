package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.permisssions.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import io.papermc.paper.command.brigadier.argument.ArgumentTypes.player
import org.bukkit.entity.Player

fun flyCommand() = commandTree("fly") {
    withPermission(PermissionRegistry.COMMAND_FLY)
    playerExecutor { player, args ->
        if (player.allowFlight) {
            player.allowFlight = false
            player.isFlying = false

            player.sendText {
                appendPrefix()
                success("Du kannst nun nicht mehr Fliegen.")
            }
        }else {
            player.allowFlight = true
            player.isFlying = true

            player.sendText {
                appendPrefix()
                success("Du kannst nun Fliegen.")
            }
        }
    }
    entitySelectorArgumentOnePlayer("player") {
        withPermission(PermissionRegistry.COMMAND_FLY_OTHERS)
        anyExecutor { executor, args ->
            val player: Player = args["player"] as Player

            if (player.allowFlight) {
                player.allowFlight = false
                player.isFlying = false


                executor.sendText {
                    appendPrefix()
                    variableValue(player.name)
                    success(" kann nun nicht mehr fliegen.")
                }

                player.sendText {
                    appendPrefix()
                    success("Du kannst nun nicht mehr fliegen.")
                }
            } else {
                player.allowFlight = true
                player.isFlying = true

                executor.sendText {
                    appendPrefix()
                    variableValue(player.name)
                    success(" kann nun fliegen.")
                }

                player.sendText {
                    appendPrefix()
                    success("Du kannst nun fliegen.")
                }
            }
        }
    }
}