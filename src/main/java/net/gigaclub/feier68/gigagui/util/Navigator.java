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

    public void openGUI(Player player) {
        ItemStack black = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").setLMeta("black").build();
        Inventory inv = Bukkit.createInventory(null, 9 * 1, OPENGUI);
        inv.setItem(1, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aHier Kommt noch was").build());
        inv.setItem(7, new ItemBuilder(Material.NETHER_STAR).setName("§aHier auch").build());
        inv.setItem(0, black);
        inv.setItem(2, black);
        inv.setItem(3, black);
        inv.setItem(5, black);
        inv.setItem(6, black);
        inv.setItem(8, black);
        if (player.hasPermission("gui.admin")) {
            inv.setItem(4, new ItemStack(new ItemBuilder(Material.TOTEM_OF_UNDYING).setName("§cAdmin GUI").setLMeta("admin").build()));
            player.openInventory(inv);
        } else
            inv.setItem(4, black);
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

                    break;
                case BRICK:
                    if (!(player.getGameMode() == GameMode.CREATIVE)) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage("Creative Mode Gesetzt");
                    } else player.sendMessage("Du bist schon im Creative");
                    break;
                case IRON_SWORD:
                    if (!(player.getGameMode() == GameMode.SURVIVAL)) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage("Survival Mode Gesetzt");
                    } else player.sendMessage("Du bist schon im Survival");
                    break;
                case SKELETON_SKULL:
                    if (!(player.getGameMode() == GameMode.SPECTATOR)) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage("Spactator Mode Gesetzt");
                    } else player.sendMessage("Du bist schon im Spactator");
                    break;
                case PAPER:
                    player.closeInventory();
                    Inventory inv2 = Bukkit.createInventory(null, 9 * 1, OPENGUI);
                    inv2.setItem(1, new ItemBuilder(Material.GOLDEN_APPLE).setName("§aHier Kommt noch was").setLMeta("test1").build());
                    inv2.setItem(7, new ItemBuilder(Material.NETHER_STAR).setName("§aHier auch").setLMeta("test2").build());
                    inv2.setItem(0, black);
                    inv2.setItem(2, black);
                    inv2.setItem(3, black);
                    inv2.setItem(5, black);
                    inv2.setItem(6, black);
                    inv2.setItem(8, black);
                    if (player.hasPermission("gigagui.admin")) {
                        inv2.setItem(4, new ItemStack(Material.TOTEM_OF_UNDYING));
                        player.openInventory(inv2);
                    } else
                        inv2.setItem(4, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
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
                    player.sendMessage("Commt noch");
                    break;


            }
        } catch (NullPointerException e) {
            System.out.print("");
        }
    }
}


