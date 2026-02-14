package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText

fun testCommand() = commandAPICommand("test") {
    withPermission(PermissionRegistry.COMMAND_TEST)
    playerExecutor { player , args ->
        player.sendText {
            appendInfoPrefix()
            info("Dies ist ein Testbefehl.")
        }
    }
}