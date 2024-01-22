package online.lxbs.minecraft.plugins.piratecraft.items;

import org.bukkit.Material;

public class RespawnBlock {

    private final String team;
    private Boolean destroyed;
    private final Material material;

    public RespawnBlock(String team, Boolean destroyed, Material material) {
        this.team = team;
        this.destroyed = destroyed;
        this.material = material;
    }

    public Boolean getDestroyed() {
        return destroyed;
    }

    public String getTeam() {
        return team;
    }

    public Material getMaterial() {
        return material;
    }

    public void setDestroyed(Boolean destroyed) {
        this.destroyed = destroyed;
    }
}
