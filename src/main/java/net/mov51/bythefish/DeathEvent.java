package net.mov51.bythefish;

import org.bukkit.entity.Player;
import org.bukkit.entity.TropicalFish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.UUID;

public class DeathEvent implements Listener {

    public static LinkedHashMap<UUID, ItemStack> summonedFish = new LinkedHashMap<>();

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDeath(EntityDeathEvent e) {
        if (e.getEntity() instanceof TropicalFish){
            System.out.println("is fish");
            if (summonedFish.containsKey(e.getEntity().getUniqueId())) {
                System.out.println("is summoned fish");
                e.setDroppedExp(0);
                e.getDrops().clear();
                e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), summonedFish.get(e.getEntity().getUniqueId()));
                summonedFish.remove(e.getEntity().getUniqueId());
            }

        }
    }
}
