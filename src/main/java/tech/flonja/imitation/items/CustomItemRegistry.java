package tech.flonja.imitation.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import tech.flonja.imitation.Imitation;
import tech.flonja.imitation.items.abilities.Ability;
import tech.flonja.imitation.items.defaults.Nuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomItemRegistry {
    private final Imitation plugin;
    private final Map<NamespacedKey, CustomItem> itemList = new HashMap<>();

    public CustomItemRegistry(Imitation plugin) {
        this.plugin = plugin;

        this.itemList.put(NamespacedKey.fromString("nuke", plugin), new Nuke());
    }

    public CustomItem getCustomItem(String customItemKey) {
        NamespacedKey key = NamespacedKey.fromString(customItemKey, plugin);
        if(!this.itemList.containsKey(key)) return null;
        return this.itemList.get(key);
    }

    public void handle(CustomItem customItem, Player player, Action action) {
        if(customItem.getAbilities() == null) return;
        for(Ability ability : customItem.getAbilities()) {
            if(ability.getActivatedWith() != action) continue;
            ability.onUse(player);
        }
    }

    public ItemStack getItemStack(CustomItem customItem) {
        NamespacedKey key = this.itemList.entrySet().stream()
                .filter(entry -> entry.getValue() == customItem)
                .findFirst().orElseThrow().getKey();

        ItemStack itemStack = new ItemStack(customItem.getMaterial(), 1);
        ItemMeta meta = Bukkit.getServer().getItemFactory().getItemMeta(customItem.getMaterial());
        if(meta == null) return null;

        meta.setDisplayName(customItem.getRarity().getColor() + customItem.getName());
        meta.setLore(this.generateLore(customItem));
        meta.getPersistentDataContainer().set(Imitation.ID, PersistentDataType.STRING, key.toString());
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    private List<String> generateLore(CustomItem customItem) {
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLACK.toString());

        if(customItem.getAbilities() != null) {
            for(Ability ability : customItem.getAbilities()) {
                String actionName = switch (ability.getActivatedWith()) {
                    case RIGHT_CLICK_BLOCK, RIGHT_CLICK_AIR -> "Right Click";
                    case LEFT_CLICK_BLOCK, LEFT_CLICK_AIR -> "Left Click";
                    case PHYSICAL -> null;
                };
                if(actionName == null) continue;
                lore.add(ChatColor.GOLD + "Ability (" + actionName + "): " + ability.getName());
                for(String line : ability.getDescription().split("\n")) {
                    lore.add(ChatColor.WHITE + "  " + line);
                }
                lore.add(ChatColor.BLACK.toString());
            }
        }

        lore.add(customItem.getRarity().getColor() + ChatColor.BOLD + customItem.getRarity().getDisplayName());
        return lore;
    }
}
