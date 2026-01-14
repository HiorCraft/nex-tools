package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText

fun discordCommand() = commandAPICommand("Discord") {
    withPermission(PermissionRegistry.COMMAND_DISCORD)
    playerExecutor { player , args ->
        player.sendText {
            appendPrefix()
            info("Unser Discord Server: ")
            variableValue("https://discord.gg/tfqj2hqDFE")
        }
    }
}