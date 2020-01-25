package net.gigaclub.feier68.gigagui.util;

import net.gigaclub.feier68.gigagui.Builder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("Hallo "+player.getName());
        player.getInventory().clear();
        player.getInventory().setItem(8,new ItemBuilder(Material.NAME_TAG).setName("§aMenu").setLore("§cÖffnet das Menu").build());
    }


}

