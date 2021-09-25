package hirosuke.alwayshunger

import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import hirosuke.alwayshunger.AlwaysHunger
import org.bukkit.command.Command

internal class CommandHunger : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (command.name == "hunger") {
            if (args.size >= 0) {
                AlwaysHunger.instance.config.set("enabled", !AlwaysHunger.instance.config.getBoolean("enabled"))
                AlwaysHunger.instance.saveConfig()
                sender.sendMessage("Toggled hunger! (current: ${AlwaysHunger.instance.config.getBoolean("enabled")})")
            }
        }
        return true
    }
}