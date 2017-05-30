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

    private void createPotsNames() {
        potsNames.add("night");
        potsNames.add("night-ext");
        potsNames.add("night-splash");
        potsNames.add("night-splash-ext");

        potsNames.add("invi");
        potsNames.add("invi-ext");
        potsNames.add("invi-splash");
        potsNames.add("invi-splash-ext");

        potsNames.add("jump");
        potsNames.add("jump-ext");
        potsNames.add("jump-up");
        potsNames.add("jump-splash");
        potsNames.add("jump-splash-ext");
        potsNames.add("jump-splash-up");

        potsNames.add("fire");
        potsNames.add("fire-ext");
        potsNames.add("fire-splash");
        potsNames.add("fire-splash-ext");

        potsNames.add("speed");
        potsNames.add("speed-ext");
        potsNames.add("speed-up");
        potsNames.add("speed-splash");
        potsNames.add("speed-splash-ext");
        potsNames.add("speed-splash-up");

        potsNames.add("heal");
        potsNames.add("heal-up");
        potsNames.add("heal-splash");
        potsNames.add("heal-splash-up");

        potsNames.add("poison");
        potsNames.add("poison-ext");
        potsNames.add("poison-up");
        potsNames.add("poison-splash");
        potsNames.add("poison-splash-ext");
        potsNames.add("poison-splash-up");

        potsNames.add("regen");
        potsNames.add("regen-ext");
        potsNames.add("regen-up");
        potsNames.add("regen-splash");
        potsNames.add("regen-splash-ext");
        potsNames.add("regen-splash-up");

        potsNames.add("strength");
        potsNames.add("strength-up");
        potsNames.add("strength-ext");
        potsNames.add("strength-splash");
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
            case "invi":
                return invi("invi");
            case "invi-ext":
                return inviExt("invi-ext");
            case "invi-splash":
                return inviSplash("invi-splash");
            case "invi-splash-ext":
                return inviSplashExt("invi-splash-ext");
            case "jump":
                return jump("jump");
            case "jump-ext":
                return jumpExt("jump-ext");
            case "jump-up":
                return jumpUp("jump-up");
            case "jump-splash":
                return jumpSplash("jump-splash");
            case "jump-splash-ext":
                return jumpSplashExt("jump-splash-ext");
            case "jump-splash-up":
                return jumpSplashUp("jump-splash-up");
            case "fire":
                return fire("fire");
            case "fire-ext":
                return fireExt("fire-ext");
            case "fire-splash":
                return fireSplash("fire-splash");
            case "fire-splash-ext":
                return fireSplashExt("fire-splash-ext");
            case "speed":
                return speed("speed");
            case "speed-ext":
                return speedExt("speed-ext");
            case "speed-up":
                return speedUp("speed-up");
            case "speed-splash":
                return speedSplash("speed-splash");
            case "speed-splash-ext":
                return speedSplashExt("speed-splash-ext");
            case "speed-splash-up":
                return speedSplashUp("speed-splash-up");
            case "heal":
                return heal("heal");
            case "heal-up":
                return healUp("heal-up");
            case "heal-splash":
                return healSplash("heal-splash");
            case "heal-splash-up":
                return healSplashUp("heal-splash-up");
            case "poison":
                return poison("poison");
            case "poison-ext":
                return poisonExt("poison-ext");
            case "poison-up":
                return poisonUp("poison-up");
            case "poison-splash":
                return poisonSplash("poison-splash");
            case "poison-splash-ext":
                return poisonSplashExt("poison-splash-ext");
            case "poison-splash-up":
                return poisonSplashUp("poison-splash-up");
            case "regen":
                return regen("regen");
            case "regen-ext":
                return regenExt("regen-ext");
            case "regen-up":
                return regenUp("regen-up");
            case "regen-splash":
                return regenSplash("regen-splash");
            case "regen-splash-ext":
                return regenSplashExt("regen-splash-ext");
            case "regen-splash-up":
                return regenSplashUp("regen-splash-up");
            case "strength":
                return strength("strength");
            case "strength-up":
                return strengthUp("strength-up");
            case "strength-ext":
                return strengthExt("strength-ext");
            case "strength-splash":
                return strengthSplash("strength-splash");
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

    public ItemStack invi(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.INVISIBILITY, false, false));

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

    public ItemStack inviSplash(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.INVISIBILITY, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack inviSplashExt(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
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

    public ItemStack jump(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.JUMP, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack jumpExt(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.JUMP, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack jumpUp(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.JUMP, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack jumpSplash(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.JUMP, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack jumpSplashExt(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.JUMP, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack jumpSplashUp(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.JUMP, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack fire(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, false, false));

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

    public ItemStack fireSplash(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack fireSplashExt(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
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

    public ItemStack speed(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.SPEED, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack speedExt(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.SPEED, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack speedUp(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.SPEED, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack speedSplash(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.SPEED, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack speedSplashExt(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.SPEED, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack speedSplashUp(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.SPEED, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack heal(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack healUp(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
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

    public ItemStack healSplash(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, false));

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

    public ItemStack poison(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.POISON, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack poisonExt(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.POISON, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack poisonUp(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
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

    public ItemStack poisonSplash(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.POISON, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack poisonSplashExt(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.POISON, true, false));

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

    public ItemStack regen(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.REGEN, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack regenExt(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.REGEN, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack regenUp(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.REGEN, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack regenSplash(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.REGEN, false, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack regenSplashExt(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.REGEN, true, false));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack regenSplashUp(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.REGEN, false, true));

        List<String> lore = new ArrayList<>();
        String line = ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("messages.pots-price-lore") +
                        plugin.getConfig().getString("potions-cost." + name));
        lore.add(line);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public ItemStack strength(String name) {
        ItemStack item = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.STRENGTH, false, false));

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

    public ItemStack strengthSplash(String name) {
        ItemStack item = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.STRENGTH, false, false));

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
