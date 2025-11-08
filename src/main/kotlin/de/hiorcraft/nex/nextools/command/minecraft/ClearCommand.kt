package de.hiorcraft.nex.nextools.command.minecraft

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentManyEntities
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOneEntity
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import io.papermc.paper.command.brigadier.argument.ArgumentTypes.player
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player


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

}