package de.hiorcraft.nex.nextools.command.minecraft

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText
import dev.slne.surf.surfapi.core.api.messages.adventure.clickCopiesToClipboard
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText

fun seedCommand() = commandTree("seed") {
    withPermission(PermissionRegistry.COMMAND_SEED)
    playerExecutor { player, _ ->
        val world = player.world
        player.sendText {
            appendPrefix()
            info("Der Seed der Welt '${world.name}' ist: ${world.seed}.")
            clickCopiesToClipboard(world.seed.toString())
            hoverEvent(buildText {
                info("Klicke, um den Seed in die Zwischenablage zu kopieren.")
            })
        }
    }

}