package tech.flonja.imitation.items;

import org.bukkit.Material;
import tech.flonja.imitation.items.abilities.Ability;

import java.util.List;

public interface CustomItem {
    Material getMaterial();
    Rarity getRarity();
    List<Ability> getAbilities();
}
