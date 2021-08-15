package josemancharo.minecraftplugin;

import org.bukkit.entity.EntityType;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SkeletonListeners implements Listener
{
    @EventHandler
    public void onTakesDamage(EntityDamageByEntityEvent event)
    {
        if (event.getEntityType() == EntityType.SKELETON 
            && event.getDamager().getType() == EntityType.PLAYER)
        {
            var player = (Player)event.getDamager();
            var skeleton = (Skeleton)event.getEntity();

            if (skeleton.getHealth() == 20 && !skeleton.getName().toString().contains("Hunter"))
            {
                skeleton.setHealth(50);
                skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
                skeleton.getEquipment().setHelmet(new ItemStack(Material.WITHER_SKELETON_SKULL));
                skeleton.setRemoveWhenFarAway(false);
                skeleton.setCustomName(player.getName() + " Hunter");
            }
            skeleton.setTarget(player);
        }
    }
}
