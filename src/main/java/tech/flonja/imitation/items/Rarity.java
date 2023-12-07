package tech.flonja.imitation.items;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;

@Getter
@RequiredArgsConstructor
public enum Rarity {
    COMMON(ChatColor.WHITE + ChatColor.BOLD.toString() + "UNCOMMON"),
    UNCOMMON(ChatColor.GREEN + ChatColor.BOLD.toString() + "UNCOMMON"),
    ADMIN(ChatColor.RED + ChatColor.BOLD.toString() + "ADMIN");

    private final String displayName;
}
