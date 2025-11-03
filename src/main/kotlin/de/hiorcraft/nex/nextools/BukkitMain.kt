package de.hiorcraft.nex.nextools

import de.hiorcraft.nex.nextools.command.minecraft.clearCommand
import de.hiorcraft.nex.nextools.command.testCommand
import org.bukkit.plugin.java.JavaPlugin

val plugin get() = JavaPlugin.getPlugin(BukkitMain::class.java)

class BukkitMain : JavaPlugin() {

    override fun onEnable() {
        logger.info("NexTools Plugin is starting.....")

        testCommand()
        clearCommand()

        logger.info("NexTools Plugin is started")
    }

    override fun onDisable() {
        logger.info("NexTools Plugin is stopping.....")
        logger.info("By <3")
    }
}
