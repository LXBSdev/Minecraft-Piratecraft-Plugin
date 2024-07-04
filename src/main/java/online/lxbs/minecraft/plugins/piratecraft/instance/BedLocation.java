package online.lxbs.minecraft.plugins.piratecraft.instance;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;

public class BedLocation extends Location {
    private final BlockFace facing;

    public BedLocation(World world, double x, double y, double z, BlockFace facing) {
        super(world, x, y, z);
        this.facing = facing;
    }

    public BlockFace getFacing() {
        return facing;
    }
}
