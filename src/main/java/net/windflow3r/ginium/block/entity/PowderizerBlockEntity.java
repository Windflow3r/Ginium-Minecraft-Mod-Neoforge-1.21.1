package net.windflow3r.ginium.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.windflow3r.ginium.item.GiniumItems;
import net.windflow3r.ginium.screen.custom.PowderizerMenu;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class PowderizerBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();

            if (level != null && !level.isClientSide()) {
                level.sendBlockUpdated(
                        getBlockPos(),
                        getBlockState(),
                        getBlockState(),
                        3
                );
            }
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final ContainerData data;

    private int progress = 0;
    private int maxProgress = 72;

    private final Random random = new Random();

    public PowderizerBlockEntity(BlockPos pos, BlockState blockState) {
        super(GiniumBlockEntities.POWDERIZER_BE.get(), pos, blockState);

        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> PowderizerBlockEntity.this.progress;
                    case 1 -> PowderizerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> PowderizerBlockEntity.this.progress = value;
                    case 1 -> PowderizerBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(
                "block.windflowersginium.powderizer"
        );
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(
            int i,
            Inventory inventory,
            Player player
    ) {
        return new PowderizerMenu(
                i,
                inventory,
                this,
                this.data
        );
    }

    public void drops() {
        SimpleContainer inventory =
                new SimpleContainer(itemHandler.getSlots());

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(
                    i,
                    itemHandler.getStackInSlot(i)
            );
        }

        Containers.dropContents(
                this.level,
                this.worldPosition,
                inventory
        );
    }

    @Override
    protected void saveAdditional(
            CompoundTag pTag,
            HolderLookup.Provider pRegistries
    ) {
        pTag.put(
                "inventory",
                itemHandler.serializeNBT(pRegistries)
        );

        pTag.putInt(
                "powderizer.progress",
                progress
        );

        pTag.putInt(
                "powderizer.max_progress",
                maxProgress
        );

        super.saveAdditional(
                pTag,
                pRegistries
        );
    }

    @Override
    protected void loadAdditional(
            CompoundTag pTag,
            HolderLookup.Provider pRegistries
    ) {
        super.loadAdditional(
                pTag,
                pRegistries
        );

        itemHandler.deserializeNBT(
                pRegistries,
                pTag.getCompound("inventory")
        );

        progress = pTag.getInt(
                "powderizer.progress"
        );

        maxProgress = pTag.getInt(
                "powderizer.max_progress"
        );
    }

    public void tick(
            Level level,
            BlockPos blockPos,
            BlockState blockState
    ) {
        if (hasRecipe()) {
            increaseCraftingProgress();

            setChanged(
                    level,
                    blockPos,
                    blockState
            );

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void craftItem() {
        ItemStack input =
                itemHandler.getStackInSlot(INPUT_SLOT);

        ItemStack output;

        if (input.is(GiniumItems.NIMBITE_SCRAP)) {
            output = new ItemStack(
                    GiniumItems.RAINPOWDER.get()
            );

        } else if (input.is(GiniumItems.GINITE_SCRAP)) {
            output = new ItemStack(
                    GiniumItems.GINPOWDER.get()
            );

        } else if (input.is(GiniumItems.ROSITE_SHARD)) {
            output = new ItemStack(
                    GiniumItems.ROSPOWDER.get()
            );

        } else if (input.is(GiniumItems.NYLITE_SHARD)) {
            output = new ItemStack(
                    GiniumItems.NYLIPOWDER.get()
            );

        } else {
            return;
        }

        int outputCount = random.nextInt(2) + 1;

        output.setCount(outputCount);

        itemHandler.extractItem(
                INPUT_SLOT,
                1,
                false
        );

        ItemStack currentOutput =
                itemHandler.getStackInSlot(OUTPUT_SLOT);

        if (currentOutput.isEmpty()) {
            itemHandler.setStackInSlot(
                    OUTPUT_SLOT,
                    output
            );
        } else {
            currentOutput.grow(
                    output.getCount()
            );

            itemHandler.setStackInSlot(
                    OUTPUT_SLOT,
                    currentOutput
            );
        }
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 72;
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        ItemStack input =
                itemHandler.getStackInSlot(INPUT_SLOT);

        ItemStack output;

        if (input.is(GiniumItems.NIMBITE_SCRAP)) {
            output = new ItemStack(
                    GiniumItems.RAINPOWDER.get(),
                    2
            );

        } else if (input.is(GiniumItems.GINITE_SCRAP)) {
            output = new ItemStack(
                    GiniumItems.GINPOWDER.get(),
                    2
            );

        } else if (input.is(GiniumItems.ROSITE_SHARD)) {
            output = new ItemStack(
                    GiniumItems.ROSPOWDER.get(),
                    2
            );

        } else if (input.is(GiniumItems.NYLITE_SHARD)) {
            output = new ItemStack(
                    GiniumItems.NYLIPOWDER.get(),
                    2
            );

        } else {
            return false;
        }

        return canInsertAmountIntoOutputSlot(
                output.getCount()
        ) && canInsertItemIntoOutputSlot(
                output
        );
    }

    private boolean canInsertItemIntoOutputSlot(
            ItemStack output
    ) {
        return itemHandler
                .getStackInSlot(OUTPUT_SLOT)
                .isEmpty()
                || itemHandler
                .getStackInSlot(OUTPUT_SLOT)
                .getItem()
                == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(
            int count
    ) {
        ItemStack output =
                itemHandler.getStackInSlot(OUTPUT_SLOT);

        int maxCount = output.isEmpty()
                ? 64
                : output.getMaxStackSize();

        int currentCount =
                output.getCount();

        return maxCount >= currentCount + count;
    }

    @Override
    public CompoundTag getUpdateTag(
            HolderLookup.Provider pRegistries
    ) {
        return saveWithoutMetadata(
                pRegistries
        );
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(
                this
        );
    }
}

