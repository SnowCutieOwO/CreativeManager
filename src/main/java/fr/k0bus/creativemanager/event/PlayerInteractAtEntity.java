package fr.k0bus.creativemanager.event;

import fr.k0bus.creativemanager.settings.Protections;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import fr.k0bus.creativemanager.CreativeManager;

public class PlayerInteractAtEntity implements Listener {

    CreativeManager plugin;

    public PlayerInteractAtEntity(CreativeManager instance) {
        plugin = instance;
    }

    @EventHandler(ignoreCancelled = true)
    public void onUse(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        if (plugin.getSettings().getProtection(Protections.ENTITY) && p.getGameMode().equals(GameMode.CREATIVE) && !p.hasPermission("creativemanager.bypass.entity")) {
            if (!p.hasPermission("creativemanager.bypass.entity") && !p.hasPermission("creativemanager.bypass.entity." + e.getRightClicked().getType().name().toLowerCase())) {
                if(plugin.getAntiSpam().containsKey(p.getUniqueId()))
                    if(plugin.getAntiSpam().get(p.getUniqueId()) < System.currentTimeMillis())
                    {
                        plugin.getAntiSpam().remove(p.getUniqueId());
                        plugin.getAntiSpam().put(p.getUniqueId(), System.currentTimeMillis() + 100);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getSettings().getTag() + plugin.getLang().getString("permission.entity")));
                    }
                e.setCancelled(true);
            }
        }
    }
}
