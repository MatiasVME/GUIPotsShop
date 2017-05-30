package org.nightmarenetwork.guipotsshop.events;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.nightmarenetwork.guipotsshop.Potions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matias on 15-05-17.
 */
public class InventoryClick implements Listener {
    private Economy econ;
    private Plugin plugin;
    private Potions potsNames;

    public InventoryClick (Plugin plugin, Economy econ, Potions potsNames) {
        this.plugin = plugin;
        this.econ = econ;
        this.potsNames = potsNames;
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent event) {
        Inventory inv = event.getInventory();

        if (!inv.getTitle().equals(ChatColor.translateAlternateColorCodes('&',
                plugin.getConfig().getString("chest-name"))))
            return;

        if (!(event.getWhoClicked() instanceof Player))
            return;

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        int slot = event.getSlot();

        boolean hasLore = item.getItemMeta().hasLore();
        boolean fullInv = this.isInventoryFull(player);

        if (item.getType() == Material.POTION || item.getType() == Material.SPLASH_POTION
                && hasLore && !fullInv) {
            double price = (double) plugin.getConfig().getInt("potions-cost."
                    + potsNames.getCurrentPotionName(slot));

            //player.sendMessage("price: " + price);
            //player.sendMessage("rute: " + "potions-cost." + potsNames.getCurrentPotionName(slot));
            //player.sendMessage("slot: " + slot);

            final double balance = econ.getBalance(player);

            if (balance >= price) {
                EconomyResponse economyResponse = econ.withdrawPlayer(player, price);

                if (economyResponse.transactionSuccess()) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            plugin.getConfig().getString("messages.bought-potion")));

                    PlayerInventory playerInv = player.getInventory();

                    ItemStack newItem = item.clone();
                    ItemMeta meta = newItem.getItemMeta();
                    List<String> lore = new ArrayList<>();
                    meta.setLore(lore);
                    newItem.setItemMeta(meta);

                    playerInv.addItem(newItem);
                }

                else {
                    player.sendMessage(plugin.getConfig().getString("messages.economy-error") +
                            economyResponse.errorMessage);
                }
            }

            else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("messages.cant-buy")));
            }
        }

        else if (fullInv) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("messages.full-inventory")));
        }

        player.updateInventory();
        event.setCancelled(true);
    }

    private boolean isInventoryFull(Player p) {
        return p.getInventory().firstEmpty() == -1;
    }
}
