package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.getValue
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import org.bukkit.entity.Player

fun godCommand() = commandTree("god"){
    withPermission(PermissionRegistry.COMMAND_GOD)
    playerExecutor { player, _ ->
        player.isInvulnerable = !player.isInvulnerable

        player.sendText {
            appendSuccessPrefix()
            success("Du bist nun")

            if(player.isInvulnerable) {
                variableValue(" im Godmode.")
            }else {
                variableValue(" nicht mehr im Godmode.")
            }
        }
    }

    entitySelectorArgumentOnePlayer("Player") {
        withPermission(PermissionRegistry.COMMAND_GOD_OTHERS)
        anyExecutor { executor, args ->
            val player: Player by args

            player.isInvulnerable = !player.isInvulnerable

            executor.sendText {
                appendSuccessPrefix()
                variableValue(player.name)
                success(" ist nun")

                if(player.isInvulnerable) {
                    variableValue(" im Godmode.")
                }else {
                    variableValue(" nicht mehr im Godmode.")
                }
            }

            player.sendText {
                appendSuccessPrefix()
                success("Du bist nun")

                if(player.isInvulnerable) {
                    variableValue(" im Godmode.")
                }else {
                    variableValue(" nicht mehr im Godmode.")
                }
            }
        }

    }
}