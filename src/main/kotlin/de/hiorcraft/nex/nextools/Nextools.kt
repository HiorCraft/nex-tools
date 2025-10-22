package de.hiorcraft.nex.nextools

import de.hiorcraft.nex.nextools.command.testCommand
import de.hiorcraft.nex.nextools.permisssions.PermissionRegistry
import org.bukkit.plugin.java.JavaPlugin

class Nextools : JavaPlugin() {

    override fun onEnable() {
        testCommand()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
