package hirosuke.alwayshunger

import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

internal class EventHunger : Listener {
    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        if (AlwaysHunger.instance.config.getBoolean("enabled")) {
            for (player in Bukkit.getServer().onlinePlayers) {
                player.foodLevel = 20
            }
        }
    }
}