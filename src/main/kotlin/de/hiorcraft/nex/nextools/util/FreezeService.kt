package de.hiorcraft.nex.nextools.util

import com.github.benmanes.caffeine.cache.Caffeine
import com.github.benmanes.caffeine.cache.Expiry
import org.bukkit.entity.Player
import java.time.Duration
import java.util.*

object FreezeService {
    private val frozenPlayers = Caffeine.newBuilder()
        .maximumSize(10_000)
        .expireAfter(Expiry.writing<UUID, Long> { _, durationMs -> Duration.ofMillis(durationMs) })
        .build<UUID, Long>()

    fun freeze(uuid: UUID, durationMs: Long) {
        frozenPlayers.put(uuid, durationMs)
    }

    fun unfreeze(uuid: UUID) {
        frozenPlayers.invalidate(uuid)
    }

    fun isFrozen(uuid: Player): Boolean {
        return frozenPlayers.getIfPresent(uuid) != null
    }
}