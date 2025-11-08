package de.hiorcraft.nex.nextools.command.minecraft

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentManyEntities
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.getValue
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import io.papermc.paper.command.brigadier.argument.ArgumentTypes.player
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player

fun killCommand() = commandTree("kill") {
    withPermission(PermissionRegistry.COMMAND_KILL)
    playerExecutor { player, _ ->
        player.damage(1000.0)

        player.sendText {
            appendPrefix()
            success("Du wurdest getötet.")
        }
    }

    entitySelectorArgumentOnePlayer("player") {
        withPermission(PermissionRegistry.COMMAND_KILL_OTHERS)
        anyExecutor { executor, args ->
            val player: Player = args["player"] as Player
            player.damage(1000.0)

            executor.sendText {
                appendPrefix()
                success("Du hast ${player.name} getötet.")
            }

            player.sendText {
                appendPrefix()
                success("Du wurdest getötet.")
            }
        }
    }

    entitySelectorArgumentManyEntities("targets") {
        withPermission(PermissionRegistry.COMMAND_KILL_OTHERS)
        anyExecutor { executor, args ->
            val targets: Collection<Entity> by args

            targets.forEach {
                if (it is LivingEntity) {
                    it.health = 0.0
                    if (it is Player) {
                        it.sendHealthUpdate()
                        it.sendText {
                            appendPrefix()
                            success("Du wurdest von ")
                            variableValue(executor.name)
                            success(" getötet.")
                        }
                    }
                } else {
                    it.remove()
                }
            }

            executor.sendText {
                appendPrefix()
                success("Du hast ")
                variableValue(targets.size.toString())
                success(" Entität(en) getötet.")
            }
        }
    }
}
