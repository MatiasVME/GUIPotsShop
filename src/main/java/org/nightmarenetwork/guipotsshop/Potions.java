package org.nightmarenetwork.guipotsshop;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 15-05-17.
 */
public class Potions {
    private Plugin plugin;
    private ArrayList<String> potsNames;
    private ArrayList<String> potsCurrentNames;

    public Potions(Plugin plugin) {
        this.plugin = plugin;

        potsNames = new ArrayList<>();
        potsCurrentNames = new ArrayList<>();

        createPotsNames();
        createPotsCurrentNames();
    }

    // borrar
    public static boolean existsNamePotion(String potionName) {
        switch (potionName) {
            case "regen":
                return true;
            case "regen-ext":
                return true;
            case "regen-ext-up":
                return true;
            case "regen-splash":
                return true;
            case "regen-splash-ext":
                return true;
        }

        return false;
    }

    private void createPotsNames() {
        potsNames.add("night");
        potsNames.add("night-ext");
        potsNames.add("night-splash");
        potsNames.add("night-splash-ext");

        //potsNames.add("invi");
        potsNames.add("invi-ext");
        //potsNames.add("invi-splash");
        //potsNames.add("invi-splash-ext");

        //potsNames.add("fire");
        potsNames.add("fire-ext");
        //potsNames.add("fire-splash");
        //potsNames.add("fire-splash-ext");

        //potsNames.add("heal");
        //potsNames.add("heal-up");
        //potsNames.add("heal-splash");
        potsNames.add("heal-splash-up");

        //potsNames.add("poison");
        //potsNames.add("poison-ext");
        //potsNames.add("poison-splash");
        //potsNames.add("poison-splash-ext");
        potsNames.add("poison-splash-up");

        /*potsNames.add("regen");
        potsNames.add("regen-ext");
        potsNames.add("regen-up");
        potsNames.add("regen-splash");
        potsNames.add("regen-splash-ext");
        potsNames.add("regen-splash-up");*/

        //potsNames.add("strength");
        potsNames.add("strength-up");
        potsNames.add("strength-ext");
        //potsNames.add("strength-splash");
        potsNames.add("strength-splash-ext");
        potsNames.add("strength-splash-up");
    }
    
    private void createPotsCurrentNames() {
        for (String pot : potsNames) {
            if (plugin.getConfig().getBoolean("potions." + pot)) {
                potsCurrentNames.add(pot);
            }
        }
    }

    public int getNumPotsEnabled () {
        return potsCurrentNames.size();
    }

    public ItemStack createPotion(String potName) {
        switch (potName) {
            case "night":
                return night("night");
            case "night-ext":
                return nightExt("night-ext");
            case "night-splash":
                return nightSplash("night-splash");
            case "night-splash-ext":
                return nightSplashExt("night-splash-ext");
            case "invi-ext":
                return inviExt("invi-ext");
            case "fire-ext":
                return fireExt("fire-ext");
            case "heal-splash-up":
                return healSplashUp("heal-splash-up");
            case "poison-splash-up":
                return poisonSplashUp("poison-splash-up");
            case "strength-up":
                return strengthUp("strength-up");
            case "strength-ext":
                return strengthExt("strength-ext");
            case "strength-splash-ext":
                return strengthSplashExt("strength-splash-ext");
            case "strength-splash-up":
                return strengthSplashUp("strength-splash-up");
            default:
                return null;
        }
    }

    public ItemStack getPotion(int numPotion) {
        ItemStack potion = createPotion(potsCurrentNames.get(numPotion));

        return potion;
    }

    public String getCurrentPotionName(int numPotion) {
        return potsCurrentNames.get(numPotion);
    }

    // Potions
    //

    public ItemStack night(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.NIGHT_VISION));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack nightExt(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.NIGHT_VISION, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack nightSplash(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.NIGHT_VISION, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack nightSplashExt(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.NIGHT_VISION, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack inviExt(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.INVISIBILITY, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack fireExt(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack healSplashUp(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack poisonSplashUp(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.POISON, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack strengthUp(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack strengthExt(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.STRENGTH, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack strengthSplashExt(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.STRENGTH, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack strengthSplashUp(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }
}
