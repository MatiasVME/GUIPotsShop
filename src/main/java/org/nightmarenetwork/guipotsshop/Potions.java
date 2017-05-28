package org.nightmarenetwork.guipotsshop;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;

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

        potsNames.add("invi");
        potsNames.add("invi-ext");
        potsNames.add("invi-splash");
        potsNames.add("invi-splash-ext");

        /*potsNames.add("regen");
        potsNames.add("regen-ext");
        potsNames.add("regen-up");
        potsNames.add("regen-ext-up");
        potsNames.add("regen-splash");
        potsNames.add("regen-splash-ext");
        potsNames.add("regen-splash-up");*/
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
                return night();
            case "night-ext":
                return nightExt();
            default:
                return null;
        }
    }

    public ItemStack getPotion(int numPotion) {
        ItemStack potion = createPotion(potsCurrentNames.get(numPotion));

        return potion;
    }

    // Potions
    //

    public ItemStack night() {
        ItemStack night = new ItemStack(Material.POTION, 1);
        PotionMeta nightMeta = (PotionMeta) night.getItemMeta();
        nightMeta.setBasePotionData(new PotionData(PotionType.NIGHT_VISION));
        night.setItemMeta(nightMeta);

        return night;
    }

    public ItemStack nightExt() {
        ItemStack nightExt = new ItemStack(Material.POTION, 1);
        PotionMeta nightMeta = (PotionMeta) nightExt.getItemMeta();
        nightMeta.setBasePotionData(new PotionData(PotionType.NIGHT_VISION, true, false));
        nightExt.setItemMeta(nightMeta);

        return nightExt;
    }
}
