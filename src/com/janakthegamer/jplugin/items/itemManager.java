package com.janakthegamer.jplugin.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class itemManager {

    public static ItemStack wand;

    public static void init() {
        createWand();
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Stick of Blast");
        List<String> lore = new ArrayList<>();
        lore.add("§7This powerful artifact is relic of");
        lore.add("§7Minecraft's ancient history!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, false);
        item.setItemMeta(meta);
        wand = item;
    }

}
