package hirosuke.alwayshunger

import org.bukkit.plugin.java.JavaPlugin
import hirosuke.alwayshunger.CommandHunger
import hirosuke.alwayshunger.EventHunger
import org.bukkit.plugin.Plugin

class AlwaysHunger : JavaPlugin() {

    companion object {
        lateinit var instance: Plugin
        private set
    }

    override fun onEnable() {
        instance = this

        saveDefaultConfig()
        getCommand("hunger").executor = CommandHunger()
        server.pluginManager.registerEvents(EventHunger(), this)
        logger.info("plugin has enabled.")
    }

    override fun onDisable() {
        logger.info("plugin has disabled.")
    }
}