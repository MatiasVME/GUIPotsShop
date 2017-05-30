package org.nightmarenetwork.guipotsshop.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import org.nightmarenetwork.guipotsshop.GUIPotsShop;
import org.nightmarenetwork.guipotsshop.Potions;

import java.util.Objects;

/**
 * Created by matias on 14-05-17.
 */
public class PotsShop implements CommandExecutor {
    private GUIPotsShop plugin;
    private Potions potNames;

    public PotsShop(GUIPotsShop guiPotsShop, Potions potNames) {
        plugin = guiPotsShop;
        this.potNames = potNames;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        boolean isPotsShop = label.equalsIgnoreCase("potsshop");

        if (isPotsShop && sender instanceof Player && args.length == 0) {
            Player player = (Player) sender;

            if (sender.hasPermission("guipotsshop.potsshop")) {
                int invSize = getInventorySize();

                Inventory inv = plugin.getServer().createInventory(null, invSize,
                        ChatColor.translateAlternateColorCodes('&',
                                plugin.getConfig().getString("chest-name")));

                inv = addPotions(inv);

                player.openInventory(inv);

                //player.sendMessage("Num of pots enabled: " + potNames.getNumPotsEnabled());
            }

            else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("messages.not-permission")));
            }
        }

        return true;
    }

    private int getInventorySize() {
        int numPotsEnabled = potNames.getNumPotsEnabled();

        if (numPotsEnabled <= 9) {
            return 9;
        }

        else if (numPotsEnabled <= 18) {
            return 18;
        }

        else if (numPotsEnabled <= 27) {
            return 27;
        }

        else if (numPotsEnabled <= 36) {
            return 36;
        }

        else if (numPotsEnabled <= 45) {
            return 45;
        }

        else if (numPotsEnabled <= 54) {
            return 54;
        }

        return 54;
    }

    private Inventory addPotions(Inventory inv) {
        for (int i = 0; i < potNames.getNumPotsEnabled(); i++) {
            ItemStack item = potNames.getPotion(i);
            inv.setItem(i, item);
        }

        return inv;
    }
}
