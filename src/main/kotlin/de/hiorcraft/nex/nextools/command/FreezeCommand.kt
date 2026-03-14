package de.hiorcraft.nex.nextools.command

import com.github.shynixn.mccoroutine.folia.entityDispatcher
import de.hiorcraft.nex.nextools.command.argument.durationArgument
import de.hiorcraft.nex.nextools.plugin
import de.hiorcraft.nex.nextools.util.FreezeService
import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.getValue
import dev.slne.surf.surfapi.bukkit.api.command.executors.anyExecutorSuspend
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import kotlinx.coroutines.future.await
import kotlinx.coroutines.withContext
import org.bukkit.entity.Player

fun freezeCommand() = commandTree("freeze") {
    withPermission(PermissionRegistry.COMMAND_FREEZE)

    entitySelectorArgumentOnePlayer("targetPlayer")
    durationArgument("duration")

    anyExecutorSuspend { sender, args ->

        val targetPlayer: Player by args
        val duration: Long by args

        val targetUuId = targetPlayer.uniqueId

        if (FreezeService.isFrozen(targetPlayer)) {
            sender.sendText {
                appendInfoPrefix()
                variableValue(targetPlayer.name)
                appendSpace()
                error("ist schon eingefrozen")
            }
            return@anyExecutorSuspend
        }

        FreezeService.freeze(targetUuId, duration)

        withContext(plugin.entityDispatcher(targetPlayer)) {
            val location = targetPlayer.location
            val world = location.world

            val teleported = targetPlayer.teleportAsync(location.toHighestLocation()).await()

            if(!teleported) {
                targetPlayer.teleportAsync(location.toHighestLocation()).await()
            }
        }

        sender.sendText {
            appendInfoPrefix()
            variableValue(targetPlayer.name)
            appendSpace()
            success("wurde jetzt eingefrozen")
        }
    }
}
