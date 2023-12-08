package tech.flonja.imitation;

import lombok.Getter;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import tech.flonja.imitation.items.CustomItem;
import tech.flonja.imitation.items.CustomItemRegistry;

@Getter
public final class Imitation extends JavaPlugin {
    public static final NamespacedKey ID = NamespacedKey.fromString("imitation:item_id");
    private final CustomItemRegistry registry = new CustomItemRegistry(this);

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) return false;
        if(!command.getName().equalsIgnoreCase("item")) return false;
        if(args.length != 1) return false;

        CustomItem customItem = this.registry.getCustomItem(args[0]);
        if(customItem == null) return false;
        player.getInventory().addItem(this.registry.getItemStack(customItem));
        return true;
    }
}
