package de.cech12.brickfurnace.compat;

import de.cech12.brickfurnace.Constants;
import de.cech12.brickfurnace.blockentity.AbstractBrickFurnaceBlockEntity;
import mcjty.theoneprobe.api.CompoundText;
import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IIconStyle;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoProvider;
import mcjty.theoneprobe.api.ITheOneProbe;
import mcjty.theoneprobe.api.ProbeMode;
import mcjty.theoneprobe.api.TextStyleClass;
import mcjty.theoneprobe.apiimpl.styles.IconStyle;
import mcjty.theoneprobe.apiimpl.styles.ProgressStyle;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.InterModComms;

import java.util.function.Function;

public class TOPCompat {

    public static void register() {
        InterModComms.sendTo("theoneprobe", "getTheOneProbe", PluginTOPRegistry::new);
    }

    public static class PluginTOPRegistry implements Function<ITheOneProbe, Void> {

        @Override
        public Void apply(ITheOneProbe probe) {
            probe.registerProvider(new IProbeInfoProvider() {
                private static final IIconStyle FIRE_STYLE =  new IconStyle().bounds(8, 8).textureBounds(8, 64);
                private static final Identifier FIRE_ICON = Identifier.withDefaultNamespace("textures/block/campfire_fire.png");

                @Override
                public Identifier getID() {
                    return Constants.id("brickfurnaceinfo");
                }

                @Override
                public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, Player player, Level level, BlockState blockState, IProbeHitData iProbeHitData) {
                    BlockEntity blockEntity = level.getBlockEntity(iProbeHitData.getPos());
                    if (blockEntity instanceof AbstractBrickFurnaceBlockEntity furnaceBlockEntity) {
                        final int burnTime = furnaceBlockEntity.getLitTotalTime();
                        final int cookTime = furnaceBlockEntity.getCookingTimer();
                        final int cookTimeTotal = furnaceBlockEntity.getCookingTotalTime();
                        if (burnTime > 0) {
                            iProbeInfo.horizontal()
                                    .icon(FIRE_ICON, 0, (int) (level.getGameTime() % 8 * 16), FIRE_STYLE.getWidth(), FIRE_STYLE.getHeight(), FIRE_STYLE)
                                    .text(CompoundText.create()
                                            .label("top.brickfurnace.fuel")
                                            .text(": ")
                                            .style(TextStyleClass.INFO)
                                            .text(Component.translatable("top.brickfurnace.n_ticks", burnTime))
                                    );
                        }
                        if (cookTime > 0) {
                            iProbeInfo.progress(cookTime, cookTimeTotal, new ProgressStyle()
                                    .suffix(Component.literal(" / " + cookTimeTotal))
                                    .alignment(ElementAlignment.ALIGN_CENTER)
                            );
                        }
                    }
                }
            });
            return null;
        }
    }
}
