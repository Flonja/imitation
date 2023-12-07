package tech.flonja.imitation;

import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import tech.flonja.imitation.items.CustomItem;

@RequiredArgsConstructor
public class EventListener implements Listener {
    private final Imitation plugin;

    @EventHandler
    public void handle(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        PersistentDataContainer container = event.getItem().getItemMeta().getPersistentDataContainer();
        if(!container.has(Imitation.ID, PersistentDataType.STRING)) return;
        String itemId = container.get(Imitation.ID, PersistentDataType.STRING);
        CustomItem customItem = this.plugin.getRegistry().getCustomItem(itemId);
        if(customItem == null) return;

        this.plugin.getRegistry().handle(customItem, event.getPlayer(), event.getAction());
    }
}
