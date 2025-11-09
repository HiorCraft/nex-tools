package de.hiorcraft.nex.nextools.util

object PermissionRegistry {

    private const val PREFIX = "nextools"
    private const val COMMAND_PREFIX = "$PREFIX.command"


    const val COMMAND_CLEAR = "$COMMAND_PREFIX.clear"
    const val COMMAND_TEST = "$COMMAND_PREFIX.test"
    const val COMMAND_SEED = "$COMMAND_PREFIX.seed"
    const val COMMAND_LIST = "$COMMAND_PREFIX.list"
    const val COMMAND_KILL = "$COMMAND_PREFIX.kill"
    const val COMMAND_KILL_OTHERS = "$COMMAND_KILL.others"
    const val COMMAND_CORDS = "$COMMAND_PREFIX.cords"
    const val COMMAND_HEALTH = "$COMMAND_PREFIX.health"
    const val COMMAND_HEALTH_OTHERS = "$COMMAND_HEALTH.others"
    const val COMMAND_INFO = "$COMMAND_PREFIX.info"
    const val COMMAND_HAT = "$COMMAND_PREFIX.hat"
    const val COMMAND_HAT_OTHERS = "$COMMAND_PREFIX.hat.others"
    const val COMMAND_FLY = "$COMMAND_PREFIX.fly"
    const val COMMAND_FLY_OTHERS = "$COMMAND_FLY.others"
    const val COMMAND_SPEED = "$COMMAND_PREFIX.speed"
    const val COMMAND_SPEED_WALK = "$COMMAND_SPEED.walk"
    const val COMMAND_SPEED_WALK_OTHERS = "$COMMAND_SPEED_WALK.others"
    const val COMMAND_SPEED_FLY = "$COMMAND_SPEED.fly"
    const val COMMAND_SPEED_FLY_OTHERS = "$COMMAND_SPEED_FLY.others"
    const val COMMAND_GOD = "$COMMAND_PREFIX.god"
    const val COMMAND_GOD_OTHERS = "$COMMAND_GOD.others"
    const val COMMAND_ITEMEDIT = "$COMMAND_PREFIX.itemedit"
    const val COMMAND_ITEMEDIT_EDIT_NAME = "$COMMAND_ITEMEDIT.editname"
    const val COMMAND_ITEMEDIT_EDIT_LORE = "$COMMAND_ITEMEDIT.editlore"
    const val COMMAND_ITEMEDIT_EDIT_ENCHANTMENTS = "$COMMAND_ITEMEDIT.editenchantments"

}