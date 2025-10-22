package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.permisssions.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.playerExecutor

fun testCommand() = commandAPICommand("test") {
    withPermission(PermissionRegistry.COMMAND_FEED)
    playerExecutor { player , args ->
        player.sendMessage("Test command executed!")
    }
}