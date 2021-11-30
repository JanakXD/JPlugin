package com.janakthegamer.jplugin;

import com.janakthegamer.jplugin.commands.JPluginCommands;
import com.janakthegamer.jplugin.events.JPluginEvents;
import com.janakthegamer.jplugin.items.itemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class JPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        itemManager.init();
        JPluginCommands commands = new JPluginCommands();
        getServer().getPluginManager().registerEvents(new JPluginEvents(), this);
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("farmtime").setExecutor(commands);
        getCommand("givewand").setExecutor(commands);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[JPlugin] Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[JPlugin] Plugin is disabled!");
    }

}
