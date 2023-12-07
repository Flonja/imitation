package tech.flonja.imitation.items.defaults;

import lombok.Getter;
import org.bukkit.Material;
import tech.flonja.imitation.items.CustomItem;
import tech.flonja.imitation.items.Rarity;
import tech.flonja.imitation.items.abilities.Ability;
import tech.flonja.imitation.items.abilities.Bomb;

import java.util.Collections;
import java.util.List;

@Getter
public class Nuke implements CustomItem {
    public final String name = "Nuke";
    public final Rarity rarity = Rarity.ADMIN;
    public final Material material = Material.TNT;

    @Override
    public List<Ability> getAbilities() {
        return Collections.singletonList(Bomb.ABILITY);
    }
}
