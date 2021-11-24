package hirosuke.alwayshunger

import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent

internal class EventHunger : Listener {
    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        if (AlwaysHunger.instance.config.getBoolean("hunger_enabled")) {
            for (player in Bukkit.getServer().onlinePlayers) {
                player.foodLevel = 20
            }
        }
    }

    @EventHandler
    fun onEntityDamagedByEntity(e: EntityDamageByEntityEvent) {
        if (AlwaysHunger.instance.config.getBoolean("health_enabled")) {
            if(e.entity is Player) {
                (e.entity as Player).health = 20.0
            }
        }
    }
}