package de.hiorcraft.nex.nextools.util

import de.hiorcraft.nex.nextools.command.cordsCommand
import de.hiorcraft.nex.nextools.command.discordCommand
import de.hiorcraft.nex.nextools.command.flyCommand
import de.hiorcraft.nex.nextools.command.godCommand
import de.hiorcraft.nex.nextools.command.hatCommand
import de.hiorcraft.nex.nextools.command.infoCommand
import de.hiorcraft.nex.nextools.command.itemEditCommand
import de.hiorcraft.nex.nextools.command.minecraft.BanCommand
import de.hiorcraft.nex.nextools.command.minecraft.BanIpCommand
import de.hiorcraft.nex.nextools.command.minecraft.clearCommand
import de.hiorcraft.nex.nextools.command.minecraft.healCommand
import de.hiorcraft.nex.nextools.command.minecraft.killCommand
import de.hiorcraft.nex.nextools.command.minecraft.listCommand
import de.hiorcraft.nex.nextools.command.minecraft.restartCommand
import de.hiorcraft.nex.nextools.command.minecraft.seedCommand
import de.hiorcraft.nex.nextools.command.spamCommand
import de.hiorcraft.nex.nextools.command.speedCommand
import de.hiorcraft.nex.nextools.command.testCommand
import de.hiorcraft.nex.nextools.command.thunderCommand
import dev.slne.surf.surfapi.bukkit.api.dialog.Dialog


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
        godCommand()
        itemEditCommand()
        spamCommand()
        thunderCommand()
        restartCommand()
        BanCommand()
        BanIpCommand()
        discordCommand()

    }

}