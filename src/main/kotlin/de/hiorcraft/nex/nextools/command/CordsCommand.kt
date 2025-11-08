package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.messages.adventure.clickCopiesToClipboard
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import org.bukkit.entity.Player


fun cordsCommand() = commandTree("cords") {
    withPermission(PermissionRegistry.COMMAND_CORDS)
    playerExecutor  { player, args ->
        val location = "Welt: ${player.world.name}, X: ${player.location.blockX}, Y: ${player.location.blockY}, Z: ${player.location.blockZ}"

        player.sendText {
            appendPrefix()
            info("Deine aktuellen Koordinaten sind: ")
            variableValue(location)
            clickCopiesToClipboard(location)
            hoverEvent(buildText {
                info("Klicke, um die Koordinaten in die Zwischenablage zu kopieren.")
            })
        }

    }

}