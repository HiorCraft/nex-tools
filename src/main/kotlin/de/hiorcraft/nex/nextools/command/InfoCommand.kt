package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.util.appendCommandButton
import de.hiorcraft.nex.nextools.util.appendLinkButton
import de.hiorcraft.nex.nextools.util.appendPrefixedKeyArrowLine
import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.getValue
import dev.slne.surf.surfapi.core.api.font.toSmallCaps
import dev.slne.surf.surfapi.core.api.messages.adventure.appendNewPrefixedLine
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player

fun infoCommand() = commandTree("info") {
    withPermission(PermissionRegistry.COMMAND_INFO)
    entitySelectorArgumentOnePlayer("player") {
        anyExecutor { executor, args ->
            val player: Player by args

            val name = player.name
            val uuid = player.uniqueId.toString()
            val host =
                "${player.virtualHost?.hostName ?: "Unbekannt"}: ${player.virtualHost?.port ?: "Unbekannt"}"
            val client = player.clientBrandName
            val labyProfile = "https://laby.net/${player.name}"
            val nameMcProfile = "https://de.namemc.com/profile/${player.name}"
            val health =
                "${player.health}/${player.getAttribute(Attribute.MAX_HEALTH)?.value ?: 20.0}"
            val food = "${player.foodLevel}/20"
            val location =
                "Welt: ${player.world.name}, X: ${player.location.blockX}, Y: ${player.location.blockY}, Z: ${player.location.blockZ}"

            val ping = "${player.ping}ms"

            executor.sendText {
                appendNewline()
                appendInfoPrefix()
                info("Spielerinformationen für ")
                variableValue(player.name.toSmallCaps())

                appendPrefixedKeyArrowLine("Name", name)
                appendPrefixedKeyArrowLine("UUID", uuid)
                appendPrefixedKeyArrowLine("Host", host)
                appendPrefixedKeyArrowLine("Client", client ?: "Unbekannt")
                appendPrefixedKeyArrowLine("Leben", health)
                appendPrefixedKeyArrowLine("Hunger", food)
                appendPrefixedKeyArrowLine("Ping", ping)
                appendPrefixedKeyArrowLine("Standort", location)

                appendNewPrefixedLine() {
                    appendLinkButton("Laby.net Profil", labyProfile)
                    appendSpace()
                    appendLinkButton("NameMC Profil", nameMcProfile)
                    appendSpace()
                    appendCommandButton("Teleportieren", "/tp $name")
                }
            }
        }
    }
}