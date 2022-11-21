package net.mov51.bythefish;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import static net.mov51.bythefish.DeathEvent.summonedFish;

public class ByTheFishCommand implements CommandExecutor{
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getName().equals("mov51")) {

                StringBuilder name = new StringBuilder();
                for (String arg : args) {
                    //check if arg is a number
                    name.append(arg).append(" ");
                }
                p.sendMessage("SAVE THE FISH NAMED " + name + "!");
                TropicalFish fish = (TropicalFish) p.getWorld().spawnEntity(p.getLocation(), EntityType.TROPICAL_FISH);
                fish.customName(Component.text(args[0]));
                fish.setCustomNameVisible(true);
                ItemStack fishItem = new ItemStack(Material.TROPICAL_FISH, 1);
                ItemMeta meta = fishItem.getItemMeta();
                meta.displayName(Component.text(name.toString()));
                fishItem.setItemMeta(meta);
                summonedFish.put(fish.getUniqueId(), fishItem);
            }
        }
        return true;
    }
}
