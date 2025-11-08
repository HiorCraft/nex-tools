package de.hiorcraft.nex.nextools.command

import de.hiorcraft.nex.nextools.util.PermissionRegistry
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.doubleArgument
import dev.jorel.commandapi.kotlindsl.entitySelectorArgumentOnePlayer
import dev.jorel.commandapi.kotlindsl.getValue
import dev.jorel.commandapi.kotlindsl.literalArgument
import dev.jorel.commandapi.kotlindsl.playerExecutor
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import io.lettuce.core.SortArgs.Builder.by
import io.papermc.paper.command.brigadier.argument.ArgumentTypes.player
import org.bukkit.entity.Player

private const val DEFAULT_SPEED_WALK = 0.2f
private const val DEFAULT_SPEED_FLY = 0.1f

fun speedCommand() = commandTree("speed") {
    withPermission(PermissionRegistry.COMMAND_SPEED)
    playerExecutor { player, _ ->
        player.walkSpeed = DEFAULT_SPEED_WALK
        player.flySpeed = DEFAULT_SPEED_FLY

        player.sendText {
            appendPrefix()
            success("Deine Geh- und Fluggeschwindigkeit wurde zurückgesetzt.")
        }
    }

    doubleArgument("speed") {
        playerExecutor { player, arguments ->
            val speed: Double by arguments

            if (speed !in 0.0..10.0) {
                player.sendText {
                    appendPrefix()
                    error("Die Geschwindigkeit muss zwischen 0 und 10 liegen.")
                }
                return@playerExecutor
            }

            player.walkSpeed = (speed.toFloat() / 10).coerceIn(0.0f, 1.0f)
            player.flySpeed = (speed.toFloat() / 10).coerceIn(0.0f, 1.0f)

            player.sendText {
                appendPrefix()
                success("Deine Geh- und Fluggeschwindigkeit wurde auf ")
                variableValue(speed.toString())
                success(" gesetzt.")
            }
        }
    }

    literalArgument("walk") {
        withPermission(PermissionRegistry.COMMAND_SPEED_WALK)
        playerExecutor { player, _ ->
            player.walkSpeed = DEFAULT_SPEED_WALK

            player.sendText {
                appendPrefix()
                success("Deine Gehgeschwindigkeit wurde zurückgesetzt.")
            }
        }
        doubleArgument("speed") {
            playerExecutor { player, arguments ->
                val speed: Double by arguments

                if (speed !in 0.0..10.0) {
                    player.sendText {
                        appendPrefix()
                        error("Die Geschwindigkeit muss zwischen 0 und 10 liegen.")
                    }
                    return@playerExecutor
                }

                player.walkSpeed = (speed.toFloat() / 10).coerceIn(0.0f, 1.0f)

                player.sendText {
                    appendPrefix()
                    success("Deine Gehgeschwindigkeit wurde auf ")
                    variableValue(speed.toString())
                    success(" gesetzt.")
                }
            }

            entitySelectorArgumentOnePlayer("player") {
                withPermission(PermissionRegistry.COMMAND_SPEED_WALK_OTHERS)
                anyExecutor { executor, args ->
                    val player: Player by args
                    val speed: Double by args

                    if (speed !in 0.0..10.0) {
                        executor.sendText {
                            appendPrefix()
                            error("Die Geschwindigkeit muss zwischen 0 und 10 liegen.")
                        }
                        return@anyExecutor
                    }

                    player.walkSpeed = (speed.toFloat() / 10).coerceIn(0.0f, 1.0f)

                    executor.sendText {
                        appendPrefix()
                        success("Du hast die Gehgeschwindigkeit von ")
                        variableValue(player.name)
                        success(" auf ")
                        variableValue(speed.toString())
                        success(" gesetzt.")
                    }
                }
            }
        }
    }

    literalArgument("fly") {
        withPermission(PermissionRegistry.COMMAND_SPEED_FLY)
        playerExecutor { player, _ ->
            player.flySpeed = DEFAULT_SPEED_FLY

            player.sendText {
                appendPrefix()
                success("Deine Fluggeschwindigkeit wurde zurückgesetzt.")
            }
        }
        doubleArgument("speed") {
            playerExecutor { player, arguments ->
                val speed: Double by arguments

                if (speed !in 0.0..10.0) {
                    player.sendText {
                        appendPrefix()
                        error("Die Geschwindigkeit muss zwischen 0 und 10 liegen.")
                    }
                    return@playerExecutor
                }

                player.flySpeed = (speed.toFloat() / 10).coerceIn(0.0f, 1.0f)

                player.sendText {
                    appendPrefix()
                    success("Deine Fluggeschwindigkeit wurde auf ")
                    variableValue(speed.toString())
                    success(" gesetzt.")
                }
            }

            entitySelectorArgumentOnePlayer("player") {
                withPermission(PermissionRegistry.COMMAND_SPEED_FLY_OTHERS)
                anyExecutor { executor, args ->
                    val player: Player = args["player"] as Player
                    val speed: Double by args

                    if (speed !in 0.0..10.0) {
                        executor.sendText {
                            appendPrefix()
                            error("Die Geschwindigkeit muss zwischen 0 und 10 liegen.")
                        }
                        return@anyExecutor
                    }

                    player.flySpeed = (speed.toFloat() / 10).coerceIn(0.0f, 1.0f)

                    executor.sendText {
                        appendPrefix()
                        success("Du hast die Fluggeschwindigkeit von ")
                        variableValue(player.name)
                        success(" auf ")
                        variableValue(speed.toString())
                        success(" gesetzt.")
                    }
                }
            }
        }
    }
}