package tech.flonja.imitation.items;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;

@Getter
@RequiredArgsConstructor
public enum Rarity {
    COMMON(ChatColor.BOLD + "UNCOMMON", ChatColor.WHITE),
    UNCOMMON(ChatColor.BOLD + "UNCOMMON", ChatColor.GREEN),
    ADMIN(ChatColor.BOLD + "ADMIN", ChatColor.RED);

    private final String displayName;
    private final ChatColor color;

    public String getColor() {
        return color.toString();
    }
}
