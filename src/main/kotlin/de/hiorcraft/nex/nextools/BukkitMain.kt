package de.hiorcraft.nex.nextools

import com.github.shynixn.mccoroutine.folia.SuspendingJavaPlugin
import de.hiorcraft.nex.nextools.managern.BukkitCommandManager
import org.bukkit.plugin.java.JavaPlugin

val plugin get() = JavaPlugin.getPlugin(BukkitMain::class.java)

class BukkitMain : SuspendingJavaPlugin() {

    override fun onEnable() {
        logger.info("NexTools Plugin is starting.....")
        BukkitCommandManager.registerAll()

        logger.info("NexTools Plugin is started")
    }

    override fun onDisable() {
        logger.info("NexTools Plugin is stopping.....")
        logger.info("By <3")
    }
}
