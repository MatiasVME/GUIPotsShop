package org.nightmarenetwork.guipotsshop.events;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.Plugin;

/**
 * Created by matias on 15-05-17.
 */
public class InventoryClick implements Listener {
    private Economy econ;
    private Plugin plugin;

    public InventoryClick (Plugin plugin, Economy econ) {
        this.plugin = plugin;
        this.econ = econ;
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent event) {
        Inventory inv = event.getInventory();

        if (!inv.getTitle().equals(plugin.getConfig().getString("chest-name")))
            return;

        if (!(event.getWhoClicked() instanceof Player))
            return;

        Player player = (Player) event.getWhoClicked();

        ItemStack item = event.getCurrentItem();

        if (item.getType() == Material.POTION) {
            PotionMeta pm = (PotionMeta) item.getItemMeta();

            Boolean isExtended = pm.getBasePotionData().isExtended();

            if (isExtended) {
                player.sendMessage("isExtended");
            }

            PlayerInventory playerInv = player.getInventory();
            playerInv.addItem(item);

            player.teleport(player.getWorld().getSpawnLocation());
            player.sendMessage("wow");

            final double balance = econ.getBalance((Player) player);

            EconomyResponse economyResponse = econ.withdrawPlayer((Player) player, 20);

            if (economyResponse.transactionSuccess()) {
                player.sendMessage("se te a quitado money");
            }

            else {
                player.sendMessage("ha ocurrido un error: " + economyResponse.errorMessage);
            }

        }

        event.setCancelled(true);
        player.closeInventory();
    }
}
