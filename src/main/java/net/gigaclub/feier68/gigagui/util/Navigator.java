package net.gigaclub.feier68.gigagui.util;

import net.gigaclub.feier68.gigagui.Builder.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.awt.dnd.DropTargetListener;

public class Navigator implements Listener {

    private final String OPENGUI = "§6§lPlayer §1G§2U§3I";


    public void openGUI(Player player){
        Inventory inv = Bukkit.createInventory(null,9*1,OPENGUI);
        inv.setItem(1,new ItemStack(Material.GOLDEN_APPLE));
        inv.setItem(7,new ItemStack(Material.NETHER_STAR));
        inv.setItem(0,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        inv.setItem(2,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        inv.setItem(3,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        inv.setItem(5,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        inv.setItem(6,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        inv.setItem(8,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        if(player.hasPermission("gui.admin")) {
            inv.setItem(4, new ItemStack(new ItemBuilder(Material.TOTEM_OF_UNDYING).setName("§cAdmin GUI").build()));
            player.openInventory(inv);
        }else
            inv.setItem(4,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        player.openInventory(inv);
    }

        private final String ADMINGUI = "admin GUI";


    @EventHandler
    public void handleNavigatorOpener(PlayerInteractEvent event){
        if (event.getItem().getType() !=Material.NAME_TAG) return;
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            openGUI(event.getPlayer());
        }
    }
    @EventHandler
    public void handleDrop(PlayerDropItemEvent event){
    if(event.getItemDrop().getItemStack().getType() == Material.NAME_TAG){
        event.isCancelled();
        event.setCancelled(true);
        }
    }
    @EventHandler
    public void handleNavigatorGUIClick(InventoryClickEvent event){

        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();

        event.setCancelled(true);
        switch (event.getCurrentItem().getType()){
            case TOTEM_OF_UNDYING:
              player.closeInventory();
                Inventory inv = Bukkit.createInventory(null,9*3,ADMINGUI);
                inv.setItem(1,new ItemBuilder(Material.BRICK).setName("§cCreative").setLore("§aSetzt dich in Creativ").build());
                inv.setItem(10,new ItemStack(Material.IRON_SWORD));
                inv.setItem(19,new ItemStack(Material.SKELETON_SKULL));
                inv.setItem(26,new ItemBuilder(Material.PAPER).setName("Zurück").build());
                player.openInventory(inv);

                break;
            case BRICK:
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("Creative Mode Gesetzt");
                break;
            case IRON_SWORD:
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage("Survival Mode Gesetzt");
                break;
            case SKELETON_SKULL:
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("Spactator Mode Gesetzt");
                break;
            case PAPER:
               player.closeInventory();
                Inventory inv2 = Bukkit.createInventory(null,9*1,OPENGUI);
                inv2.setItem(1,new ItemStack(Material.GOLDEN_APPLE));
                inv2.setItem(7,new ItemStack(Material.NETHER_STAR));
                inv2.setItem(0,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
                inv2.setItem(2,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
                inv2.setItem(3,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
                inv2.setItem(5,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
                inv2.setItem(6,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
                inv2.setItem(8,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
                if(player.hasPermission("gigagui.admin")) {
                    inv2.setItem(4, new ItemStack(Material.TOTEM_OF_UNDYING));
                    player.openInventory(inv2);
                }else
                    inv2.setItem(4,new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
                    player.openInventory(inv2);

                player.openInventory(inv2);
                break;
            case BLACK_STAINED_GLASS_PANE:
                player.closeInventory();
                break;
            case GOLDEN_APPLE:
                player.sendMessage("Commt noch");
                break;
            case NETHER_STAR:
                player.sendMessage("commt noch");
                break;


        }

    }



}


