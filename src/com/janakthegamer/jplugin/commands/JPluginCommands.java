package com.janakthegamer.jplugin.commands;

import com.janakthegamer.jplugin.items.itemManager;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Locale;

public class JPluginCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "A player is required to run this command here");
            return true;
        }
        Player player = (Player) sender;

        // Command : /heal
        if (cmd.getName().equalsIgnoreCase("heal")) {
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage("§e§l[!] §eYou Have Been Healed!");
        }

        else if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
            player.sendMessage("§e§l[!] §eYou Have Been Fed!");
        }

        else if (cmd.getName().equalsIgnoreCase("givewand")) {
            player.getInventory().addItem(itemManager.wand);
        }

        else if (cmd.getName().equalsIgnoreCase("farmtime")) {
            if (args.length >= 2) {
                try {
                    EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                    int amount = Integer.parseInt(args[1]);
                    for (int i = 0; i < amount; i++) {
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                } catch (IllegalArgumentException e) {
                    player.sendMessage("§c§l[!] §cInvalid Entity Passed");
                }
            } else {
                player.sendMessage("§c§l[!] §cIncorrect Arguments Passed\n§aCorrect format : /farmtime <mob> <amount>");
            }

        }

        return true;
    }
}
