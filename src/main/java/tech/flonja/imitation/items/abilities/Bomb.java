package tech.flonja.imitation.items.abilities;

import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

@Getter
public class Bomb implements Ability {
    private final String name = "Bomb";
    private final String description = "Create a big explosion in one action!";
    private final Action activatedWith = Action.LEFT_CLICK_AIR;

    @Override
    public void onUse(Player player) {
        player.getWorld().createExplosion(player.getLocation(), 10F, true, true, (Entity) this);
    }
}
