package org.nightmarenetwork.guipotsshop;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.nightmarenetwork.guipotsshop.commands.PotsShop;
import org.nightmarenetwork.guipotsshop.events.InventoryClick;

import java.io.File;
import java.util.logging.Logger;

public final class GUIPotsShop extends JavaPlugin {

    private static Economy econ = null;

    private static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            // Deshabilita el plugin en caso de que no encuentre el plugin de vault
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Config
        //

        File config = new File(getDataFolder() + File.separator + "config.yml");

        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        // Classes
        //

        Potions potNames = new Potions(this);

        //getLogger().info(getConfig().getString("bienvenida"));

        // Commands
        //

        getCommand("potsshop").setExecutor(new PotsShop(this, potNames));

        // Listeners
        //

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryClick(this, econ, potNames), this);
    }

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {

            return false;
        }

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);

        if (rsp == null) {
            return false;
        }

        econ = rsp.getProvider();

        return econ != null;
    }

    public static Economy getEcononomy() {
        return econ;
    }
}
