package fr.k0bus.creativemanager.event.plugin;

import dev.lone.itemsadder.api.Events.*;
import fr.k0bus.creativemanager.CreativeManager;
import fr.k0bus.creativemanager.settings.Protections;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class ItemsAdderListener implements Listener  {

    final HashMap<String, String> replaceMap = new HashMap<>();
    CreativeManager plugin;
    public ItemsAdderListener(CreativeManager plugin)
    {
        replaceMap.put("{PLUGIN}", "SlimeFun");
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlaceFurniture(FurniturePlaceEvent e)
    {
        Player p = e.getPlayer();
        if(!CreativeManager.getSettings().getProtection(Protections.PL_ITEMSADDER)) return;
        if(!p.getGameMode().equals(GameMode.CREATIVE)) return;
        if(p.hasPermission("creativemanager.bypass.itemsadder.furnituresplace")) return;
        plugin.sendMessage(p, CreativeManager.TAG + CreativeManager.getLang().getString("permission.plugin", replaceMap));
        e.setCancelled(true);

    }
    @EventHandler
    public void onBlockPlace(CustomBlockPlaceEvent e)
    {
        Player p = e.getPlayer();
        if(!CreativeManager.getSettings().getProtection(Protections.PL_ITEMSADDER)) return;
        if(!p.getGameMode().equals(GameMode.CREATIVE)) return;
        if(p.hasPermission("creativemanager.bypass.itemsadder.blockplace")) return;
        plugin.sendMessage(p, CreativeManager.TAG + CreativeManager.getLang().getString("permission.plugin", replaceMap));
        e.setCancelled(true);
    }
    @EventHandler
    public void onBlockBreak(CustomBlockBreakEvent e)
    {
        Player p = e.getPlayer();
        if(!CreativeManager.getSettings().getProtection(Protections.PL_ITEMSADDER)) return;
        if(!p.getGameMode().equals(GameMode.CREATIVE)) return;
        if(p.hasPermission("creativemanager.bypass.itemsadder.blockbreak")) return;
        plugin.sendMessage(p, CreativeManager.TAG + CreativeManager.getLang().getString("permission.plugin", replaceMap));
        e.setCancelled(true);
    }
    @EventHandler
    public void onBlockInteract(CustomBlockInteractEvent e)
    {
        Player p = e.getPlayer();
        if(!CreativeManager.getSettings().getProtection(Protections.PL_ITEMSADDER)) return;
        if(!p.getGameMode().equals(GameMode.CREATIVE)) return;
        if(p.hasPermission("creativemanager.bypass.itemsadder.blockinteract")) return;
        plugin.sendMessage(p, CreativeManager.TAG + CreativeManager.getLang().getString("permission.plugin", replaceMap));
        e.setCancelled(true);
    }
    @EventHandler
    public void onFurnitureInteract(FurnitureInteractEvent e)
    {
        Player p = e.getPlayer();
        if(!CreativeManager.getSettings().getProtection(Protections.PL_ITEMSADDER)) return;
        if(!p.getGameMode().equals(GameMode.CREATIVE)) return;
        if(p.hasPermission("creativemanager.bypass.itemsadder.furnituresinteract")) return;
        plugin.sendMessage(p, CreativeManager.TAG + CreativeManager.getLang().getString("permission.plugin", replaceMap));
        e.setCancelled(true);
    }
    @EventHandler
    public void onEntityDie(CustomEntityDeathEvent e)
    {
        if(e.getKiller() == null) return;
        if(!(e.getKiller() instanceof Player p)) return;
        if(!CreativeManager.getSettings().getProtection(Protections.PL_ITEMSADDER)) return;
        if(!p.getGameMode().equals(GameMode.CREATIVE)) return;
        if(p.hasPermission("creativemanager.bypass.itemsadder.killentity")) return;
        plugin.sendMessage(p, CreativeManager.TAG + CreativeManager.getLang().getString("permission.plugin", replaceMap));
        p.setLastDamage(0);
    }
}
