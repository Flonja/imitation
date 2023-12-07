package tech.flonja.imitation;

import lombok.Getter;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import tech.flonja.imitation.items.CustomItemRegistry;

@Getter
public final class Imitation extends JavaPlugin {
    public static final NamespacedKey ID = NamespacedKey.fromString("imitation:item_id");
    private final CustomItemRegistry registry = new CustomItemRegistry(this);

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
    }
}
