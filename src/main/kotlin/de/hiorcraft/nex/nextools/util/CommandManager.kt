package de.hiorcraft.nex.nextools.util

import de.hiorcraft.nex.nextools.command.cordsCommand
import de.hiorcraft.nex.nextools.command.flyCommand
import de.hiorcraft.nex.nextools.command.hatCommand
import de.hiorcraft.nex.nextools.command.infoCommand
import de.hiorcraft.nex.nextools.command.minecraft.clearCommand
import de.hiorcraft.nex.nextools.command.minecraft.healCommand
import de.hiorcraft.nex.nextools.command.minecraft.killCommand
import de.hiorcraft.nex.nextools.command.minecraft.listCommand
import de.hiorcraft.nex.nextools.command.minecraft.seedCommand
import de.hiorcraft.nex.nextools.command.speedCommand
import de.hiorcraft.nex.nextools.command.testCommand

object BukkitCommandManager {
    fun registerAll() {
        testCommand()
        clearCommand()
        seedCommand()
        listCommand()
        killCommand()
        cordsCommand()
        healCommand()
        infoCommand()
        hatCommand()
        flyCommand()
        speedCommand()

    }

}