package com.janakthegamer.jplugin.events;

import com.janakthegamer.jplugin.items.itemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class JPluginEvents implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Welcome to the Server! :)");
    }

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(itemManager.wand.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.getWorld().createExplosion(player.getLocation(), 3.0f);
                    player.sendMessage("§6Using this stick will cost your life");
                }
            }
        }
    }
}
