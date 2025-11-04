package de.hiorcraft.nex.nextools.managern

import de.hiorcraft.nex.nextools.command.cordsCommand
import de.hiorcraft.nex.nextools.command.minecraft.clearCommand
import de.hiorcraft.nex.nextools.command.minecraft.killCommand
import de.hiorcraft.nex.nextools.command.minecraft.listCommand
import de.hiorcraft.nex.nextools.command.minecraft.seedCommand
import de.hiorcraft.nex.nextools.command.testCommand

object BukkitCommandManager {
    fun registerAll() {
        testCommand()
        clearCommand()
        seedCommand()
        listCommand()
        killCommand()
        cordsCommand()
    }

}