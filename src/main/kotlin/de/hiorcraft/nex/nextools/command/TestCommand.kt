package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.literalArgument
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.buildText

fun testCommand() = commandAPICommand("test") {
    withPermission(PermissionRegistry.COMMAND_TEST)

    playerExecutor { player, _ ->
        player.sendMessage("Hier sind paar Testnachrichten:")
    }

    literalArgument("Ranks") {
        playerExecutor { player, args ->
            buildText {
                spacer("-------------------------------")
                info("Admin = \uE000")
                spacer("")
                info("Developer = \uE002")
                spacer("")
                info("Moderator = \uE004")
                spacer("")
                info("supporter = \uE007")
                spacer("")
                info("Vip = \uE008")
                spacer("")
                info("Content Creator = \uE001")
                spacer("")
                info("Premium+ = \uE006")
                spacer("")
                info("Premium = \uE005")
                spacer("")
                info("Member = \uE003")
                spacer("-------------------------------")
            }
        }
    }
}