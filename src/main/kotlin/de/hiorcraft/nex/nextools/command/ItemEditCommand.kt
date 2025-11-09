package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.enchantmentArgument
import dev.jorel.commandapi.kotlindsl.getValue
import dev.jorel.commandapi.kotlindsl.greedyStringArgument
import dev.jorel.commandapi.kotlindsl.integerArgument
import dev.jorel.commandapi.kotlindsl.literalArgument
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.meta.ItemMeta

fun itemEditCommand() =commandTree("itemedit") {
    withPermission(PermissionRegistry.COMMAND_ITEMEDIT)
    literalArgument("displayname") {
        greedyStringArgument("name") {
            withPermission(PermissionRegistry.COMMAND_ITEMEDIT_EDIT_NAME)
            playerExecutor { player, args ->
                val name: String by args
                val displayName = MiniMessage.miniMessage().deserialize(name)
                val itemInHand = player.inventory.itemInMainHand

                if (itemInHand.isEmpty) {
                    player.sendText {
                        appendPrefix()
                        error("Du musst ein Item in der Hand halten.")
                    }
                    return@playerExecutor
                }

                itemInHand.editMeta(ItemMeta::class.java) {
                    it.displayName(
                        displayName.decorationIfAbsent(
                            TextDecoration.ITALIC,
                            TextDecoration.State.FALSE
                        )
                    )
                }

                player.sendText {
                    appendPrefix()
                    success("Der Anzeigename des Items wurde zu ")
                    variableValue(name)
                    success(" geändert.")
                }
            }
        }
    }

    literalArgument("lore") {
        integerArgument("line") {
            greedyStringArgument("loreContent") {
                withPermission(PermissionRegistry.COMMAND_ITEMEDIT_EDIT_LORE)
                playerExecutor { player, args ->
                    val line: Int by args
                    val loreContent: String by args
                    val displayLoreContent = MiniMessage.miniMessage().deserialize(loreContent)
                    val itemInHand = player.inventory.itemInMainHand

                    if (itemInHand.isEmpty) {
                        player.sendText {
                            appendPrefix()
                            error("Du musst ein Item in der Hand halten.")
                        }
                        return@playerExecutor
                    }

                    itemInHand.editMeta(ItemMeta::class.java) {
                        val lore = it.lore()?.toMutableList() ?: mutableListOf()

                        val safeIndex = line.coerceIn(0, lore.size)
                        lore.add(safeIndex, displayLoreContent)

                        it.lore(lore)
                    }

                    player.sendText {
                        appendPrefix()
                        success("Die Lore-Zeile ")
                        variableValue(line)
                        success(" des Items wurde zu ")
                        append(displayLoreContent)
                        success(" geändert.")
                    }
                }
            }
        }
    }

    literalArgument("enchant") {
        enchantmentArgument("enchant") {
            integerArgument("level") {
                withPermission(PermissionRegistry.COMMAND_ITEMEDIT_EDIT_ENCHANTMENTS)
                playerExecutor { player, args ->
                    val enchant: Enchantment by args
                    val level: Int by args
                    val itemInHand = player.inventory.itemInMainHand

                    if (itemInHand.isEmpty) {
                        player.sendText {
                            appendPrefix()
                            error("Du musst ein Item in der Hand halten.")
                        }
                        return@playerExecutor
                    }

                    itemInHand.editMeta(ItemMeta::class.java) {
                        it.addEnchant(enchant, level, true)
                    }

                    player.sendText {
                        appendPrefix()
                        success("Der Verzauberung ")
                        variableValue(enchant.key.key)
                        success(" mit der Stufe ")
                        variableValue(level.toString())
                        success(" wurde zum Item hinzugefügt.")
                    }
                }
            }
        }
    }
}