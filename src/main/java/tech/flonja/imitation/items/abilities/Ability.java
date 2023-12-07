package tech.flonja.imitation.items.abilities;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

public interface Ability {

    String getName();
    String getDescription();
    Action getActivatedWith();
    void onUse(Player player);
}
