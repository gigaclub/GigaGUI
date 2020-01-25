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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Navigator implements Listener {

    private final String OPENGUI = "§6§lPlayer §1G§2U§3I";


    private final String ADMINGUI = "admin GUI";


}

    public void openGUI(Player player) {
        ItemStack black = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").setLMeta("black").build();
        int invSlot = 9 * 5;
        Inventory inv = Bukkit.createInventory(null, invSlot, OPENGUI);
        for (int i = 0; i <= invSlot - 1; i++)
            inv.setItem(i, black);
        inv.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setName("§a" + player.getName()).setLore("Hier kommen noch daten vom spieler hin").setLore().build());
        inv.setItem(28, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aHier Kommt noch was").setLMeta("test1").build());
        inv.setItem(34, new ItemBuilder(Material.NETHER_STAR).setName("§aHier auch").setLMeta("test2").build());
        if (player.hasPermission("gigagui.admin")) {
            inv.setItem(31, new ItemBuilder(Material.TOTEM_OF_UNDYING).setName("§cAdmin §1Menu").build());
            player.openInventory(inv);
        }
        player.openInventory(inv);
    }


    @EventHandler
    public void handleNavigatorOpener(PlayerInteractEvent event) {
        try {
            if (event.getItem().getType() != Material.NAME_TAG) return;
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                openGUI(event.getPlayer());
            }
        } catch (NullPointerException e) {
            System.out.print("");
        }
    }


    @EventHandler
    public void handleDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getType() == Material.NAME_TAG) {
            event.isCancelled();
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void handleNavigatorGUIClick(InventoryClickEvent event) {

        try {
            ItemStack black = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").setLMeta("black").build();
            if (!(event.getWhoClicked() instanceof Player)) return;
            Player player = (Player) event.getWhoClicked();

            event.setCancelled(true);


            switch (event.getCurrentItem().getType()) {
                case TOTEM_OF_UNDYING:
                    if (player.getOpenInventory().getItem(0).getType() == Material.BLACK_STAINED_GLASS_PANE) {
                        player.closeInventory();
                        int slots = 9 * 3;
                        Inventory inv = Bukkit.createInventory(null, slots, ADMINGUI);
                        for (int i = 0; i <= slots - 1; i++)
                            inv.setItem(i, black);
                        inv.setItem(1, new ItemBuilder(Material.BRICK).setName("§cCreative").setLore("§aSetzt dich in Creativ").setLMeta("creativ").build());
                        inv.setItem(10, new ItemBuilder(Material.IRON_SWORD).setName("§2Survival").setLore("§aSetzt dich in Survival").setLMeta("survival").build());
                        inv.setItem(19, new ItemBuilder(Material.SKELETON_SKULL).setName("§fSpactator").setLMeta("spactator").setLore("§aSetzt dich zu Spactator").build());
                        inv.setItem(26, new ItemBuilder(Material.PAPER).setName("§7Zurück").setLMeta("zurück").build());
                        player.openInventory(inv);
                    }
                    break;
                case BRICK:
                    if (player.getOpenInventory().getItem(0).getType() == Material.BLACK_STAINED_GLASS_PANE) {
                        if (!(player.getGameMode() == GameMode.CREATIVE)) {
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage("Creative Mode Gesetzt");
                        } else player.sendMessage("");
                    }
                    break;
                case IRON_SWORD:
                    if (player.getOpenInventory().getItem(0).getType() == Material.BLACK_STAINED_GLASS_PANE) {
                        if (!(player.getGameMode() == GameMode.SURVIVAL)) {
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage("Survival Mode Gesetzt");
                        } else player.sendMessage("");
                    }
                    break;
                case SKELETON_SKULL:
                    if (player.getOpenInventory().getItem(0).getType() == Material.BLACK_STAINED_GLASS_PANE) {
                        if (!(player.getGameMode() == GameMode.SPECTATOR)) {
                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage("Spactator Mode Gesetzt");
                        } else player.sendMessage("");
                    }
                    break;
                case PAPER:
                    if (player.getOpenInventory().getItem(0).getType() == Material.BLACK_STAINED_GLASS_PANE) {
                        player.closeInventory();
                        int inv2slot = 9 * 5;
                        Inventory inv2 = Bukkit.createInventory(null, inv2slot, OPENGUI);
                        for (int i = 0; i <= inv2slot - 1; i++)
                            inv2.setItem(i, black);
                        inv2.setItem(13, new ItemBuilder(Material.PLAYER_HEAD).setName("§a" + player.getName()).build());
                        inv2.setItem(19, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aHier Kommt noch was").setLMeta("test1").build());
                        inv2.setItem(25, new ItemBuilder(Material.NETHER_STAR).setName("§aHier auch").setLMeta("test2").build());
                        if (player.hasPermission("gigagui.admin")) {
                            inv2.setItem(31, new ItemBuilder(Material.TOTEM_OF_UNDYING).setName("§cAdmin §1Menu").build());
                            player.openInventory(inv2);
                        }
                        player.openInventory(inv2);
                    }
                    break;
                case BLACK_STAINED_GLASS_PANE:
                    if (player.getOpenInventory().getItem(0).getType() == Material.BLACK_STAINED_GLASS_PANE) {
                        player.closeInventory();
                    }
                    break;
                case GOLDEN_APPLE:
                case NETHER_STAR:
                    if (player.getOpenInventory().getItem(0).getType() == Material.BLACK_STAINED_GLASS_PANE) {
                        player.sendMessage("§aCommt noch");
                    }
                    break;
            }
        } catch (NullPointerException e) {
            System.out.print("");
        }
    }

}


