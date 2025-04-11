package net.gabotb.cuteandround.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.gabotb.cuteandround.menu.FluffyCrittersGuideContainerMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class FluffyCrittersGuideMenu extends AbstractContainerScreen<FluffyCrittersGuideContainerMenu> {

    private static final ResourceLocation BACKGROUND = ResourceLocation.tryParse("cuteandround:textures/gui/fluffy_guide_book.png");

    private enum Page { INTRO, ITEMS }
    private Page currentPage = Page.INTRO;
    private int currentItemPage = 0;
    private boolean showIndex = false;

    public FluffyCrittersGuideMenu(FluffyCrittersGuideContainerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 256; // Ancho de la ventana
        this.imageHeight = 188; // Alto de la ventana
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        // Renderizar el fondo del menú
        RenderSystem.setShaderTexture(0, BACKGROUND);
        guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        guiGraphics.drawString(this.font, "Fluffy Critters Guide", this.leftPos + 10, this.topPos + 10, 0xFFFFFF, false);

        // Renderizar contenido basado en la página actual
        if (currentPage == Page.INTRO) {
            renderIntroPage(guiGraphics);
        } else if (currentPage == Page.ITEMS) {
            renderItemsPage(guiGraphics);
        }

        if (showIndex) {
            renderIndex(guiGraphics);
        }
    }

    private void renderIntroPage(GuiGraphics guiGraphics) {
        String[] introLines = {
                "Welcome to Fluffy Critters Guide!",
                "",
                "This mod brings adorable animals to Minecraft,",
                "from tiny rabbits to huge capybaras.",
                "Each animal has its own unique behavior",
                "and characteristics.",
                "",
                "Explore new biomes and discover these",
                "fluffy critters!"
        };

        int yOffset = 30;
        for (String line : introLines) {
            guiGraphics.drawString(this.font, line, this.leftPos + 10, this.topPos + yOffset, 0xFFFFFF, false);
            yOffset += 10;
        }
    }

    private void renderItemsPage(GuiGraphics guiGraphics) {
        guiGraphics.drawString(this.font, "Items Page", this.leftPos + 10, this.topPos + 30, 0xFFFFFF, false);
    }

    private void renderIndex(GuiGraphics guiGraphics) {
        guiGraphics.drawString(this.font, "Index", this.leftPos + 10, this.topPos + 70, 0xFFFFFF, false);
    }

    @Override
    protected void init() {
        super.init();

        // Botón de Índice
        this.addRenderableWidget(Button.builder(Component.literal("Index"), button -> {
            showIndex = !showIndex;
        }).bounds(this.leftPos + 10, this.topPos + 50, 50, 20).build());

        // Botón para Introducción
        this.addRenderableWidget(Button.builder(Component.literal("Intro"), button -> {
            currentPage = Page.INTRO;
        }).bounds(this.leftPos + 50, this.topPos + 100, 100, 20).build());

        // Botón para Items
        this.addRenderableWidget(Button.builder(Component.literal("Items"), button -> {
            currentPage = Page.ITEMS;
        }).bounds(this.leftPos + 50, this.topPos + 130, 100, 20).build());
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        // Renderizar el fondo y los elementos
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // Renderizar etiquetas o texto dentro del menú
        guiGraphics.drawString(this.font, this.title.getString(), 10, 10, 0x404040, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle.getString(), 10, this.imageHeight - 94, 0x404040, false);
    }
}