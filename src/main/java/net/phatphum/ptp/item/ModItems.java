package net.phatphum.ptp.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.phatphum.ptp.PTPModMain;

public class ModItems {

    public static final Item PLASTIC = registerItem("plastic", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PTPModMain.MODID, name), item);
    }

    public static void addItemToGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, PLASTIC);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        PTPModMain.LOGGER.debug("Register Mod Items for " + PTPModMain.MODID);

        addItemToGroup();
    }
}
