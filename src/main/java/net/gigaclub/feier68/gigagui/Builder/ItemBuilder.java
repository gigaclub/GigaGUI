package net.gigaclub.feier68.gigagui.Builder;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemBuilder extends ItemStack {

    protected ItemStack item;
    protected ItemMeta itemMeta;

    public ItemBuilder(Material material, short subID) {
        item = new ItemStack(material, 1, subID);
        itemMeta = item.getItemMeta();
    }

    public ItemBuilder(Material material) {
        this(material, (short)0);
    }

    public ItemBuilder setName(String name) {
        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder setLMeta(String Lmeta) {
        itemMeta.setLocalizedName("");
        return this;
    }

    public ItemBuilder setMetadat(String mata, String data) {

        return this;
    }

    public ItemStack build() {
        item.setItemMeta(itemMeta);
        return item;
    }


}


