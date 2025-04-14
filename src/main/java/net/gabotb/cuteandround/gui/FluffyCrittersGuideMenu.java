package net.gabotb.cuteandround.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.gabotb.cuteandround.menu.FluffyCrittersGuideContainerMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

public class FluffyCrittersGuideMenu extends AbstractContainerScreen<FluffyCrittersGuideContainerMenu> {

    private static final ResourceLocation BACKGROUND = ResourceLocation.tryParse("cuteandround:textures/gui/fluffy_guide_book.png");
    private static final ResourceLocation TITLE_IMAGE = ResourceLocation.tryParse("cuteandround:textures/gui/cuteandround_title.png");

    private enum Page { HOME, INTRO, ITEMS }

    private Page currentPage = Page.HOME;
    private static final List<String> ITEMS = List.of(
            "Banana",
            "Alfalfa Seeds",
            "Sand Bath Block"
    );

    private int pageNumber = 0;

    public FluffyCrittersGuideMenu(FluffyCrittersGuideContainerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 440;
        this.imageHeight = 256;
    }

    @Override
    protected void init() {
        super.init();
        this.clearWidgets();

        int rightPageX = this.leftPos + (this.imageWidth / 2) + 20;
        int arrowY = this.topPos + this.imageHeight - 55;

        // Flechas de página solo si no estamos en la página HOME y hay más contenido
        if (currentPage != Page.HOME) {
            if (canGoToNextPage()) {
                this.addRenderableWidget(new VanillaStyleButton(this.leftPos + 44, arrowY, "←", button -> {
                    goToPreviousPage();
                    playPageChangeSound();
                }));

                this.addRenderableWidget(new VanillaStyleButton(this.leftPos + this.imageWidth - 50, arrowY, "→", button -> {
                    goToNextPage();
                    playPageChangeSound();
                }));
            }
        }

        // Botones de página HOME
        if (currentPage == Page.HOME) {
            this.addRenderableWidget(new VanillaStyleButton(rightPageX, this.topPos + 50, "• Introduction", button -> {
                currentPage = Page.INTRO;
                pageNumber = 0;
                init();
                playPageChangeSound();  // Sonido al abrir INTRO
            }));

            this.addRenderableWidget(new VanillaStyleButton(rightPageX, this.topPos + 70, "• Items", button -> {
                currentPage = Page.ITEMS;
                pageNumber = 0;
                init();
                playPageChangeSound();  // Sonido al abrir ITEMS
            }));
        }

        // Botón <- Back si no estamos en HOME
        if (currentPage != Page.HOME) {
            this.addRenderableWidget(new VanillaStyleButton(this.leftPos + 60, this.topPos + 30, "<- Back", button -> {
                currentPage = Page.HOME;
                pageNumber = 0;
                init();
                playPageChangeSound();  // Sonido al volver al HOME
            }));
        }
    }

    private boolean canGoToNextPage() {
        // Verificar si la página tiene más contenido
        if (currentPage == Page.INTRO && pageNumber == 0) {
            return false; // No hay más contenido en INTRO
        }

        if (currentPage == Page.ITEMS && pageNumber == 0) {
            return false; // No hay más contenido en ITEMS
        }

        return true; // Puede pasar a la siguiente página
    }

    private void playPageChangeSound() {
        Minecraft.getInstance().player.playSound(SoundEvents.BOOK_PAGE_TURN, 1.0F, 1.0F);
    }

    private void goToPreviousPage() {
        if (currentPage != Page.HOME && pageNumber > 0) {
            pageNumber--;
            init();
        } else if (currentPage != Page.HOME && pageNumber == 0) {
            currentPage = Page.HOME;
            init();
        }
    }

    private void goToNextPage() {
        if (currentPage == Page.INTRO && pageNumber == 0) {
            pageNumber++; // futuro soporte para más contenido
            init();
        } else if (currentPage == Page.ITEMS && pageNumber == 0) {
            pageNumber++; // Ir a la página siguiente de ITEMS
            init();
        }
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, BACKGROUND);
        guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, 440, 256);
        renderLeftPage(guiGraphics);
        renderRightPage(guiGraphics);
    }

    private void renderLeftPage(GuiGraphics guiGraphics) {
        int pageLeft = this.leftPos + 30;
        int pageTop = this.topPos + 22;
        int pageWidth = 176;
        int xCenter = pageLeft + (pageWidth / 2) + 10;

        if (currentPage == Page.HOME) {
            RenderSystem.setShaderTexture(0, TITLE_IMAGE);
            int spriteWidth = 108;
            int spriteHeight = 148;
            int imageX = pageLeft + (pageWidth - spriteWidth) / 2;
            int imageY = pageTop + (154 - spriteHeight) / 2;
            guiGraphics.blit(TITLE_IMAGE, imageX, imageY, 0, 0, spriteWidth, spriteHeight, spriteWidth, spriteHeight);
        } else if (currentPage == Page.INTRO && pageNumber == 0) {
            String[] introLines = {
                    "Welcome to Fluffy Critters Guide!",
                    "",
                    "This mod brings adorable animals,",
                    "from rabbits to capybaras.",
                    "Each animal has its own unique",
                    "behavior and characteristics.",
                    "",
                    "Explore new biomes and",
                    "discover these fluffy critters!"
            };

            int yOffset = this.topPos + 40;
            for (String line : introLines) {
                this.font.drawInBatch(
                        line,
                        xCenter - (this.font.width(line) / 2f),
                        yOffset,
                        0x404040,
                        false,
                        guiGraphics.pose().last().pose(),
                        guiGraphics.bufferSource(),
                        Font.DisplayMode.NORMAL,
                        0,
                        15728880
                );
                yOffset += 12;
            }
        } else if (currentPage == Page.ITEMS && pageNumber == 0) {
            int xOffset = pageLeft + 20;
            int yOffset = this.topPos + 40;
            for (String item : ITEMS) {
                guiGraphics.drawString(this.font, "- " + item, xOffset, yOffset, 0x404040, false);
                yOffset += 12;
            }
        }
    }

    private void renderRightPage(GuiGraphics guiGraphics) {
        if (currentPage == Page.HOME) {
            int titleX = this.leftPos + (this.imageWidth / 2) + 20;
            guiGraphics.drawString(this.font, "Fluffy Critters Guide", titleX, this.topPos + 25, 0x404040, false);
            guiGraphics.drawString(this.font, "________________________", titleX, this.topPos + 28, 0x404040, false);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {}

    private static class VanillaStyleButton extends Button {
        public VanillaStyleButton(int x, int y, String message, OnPress onPress) {
            super(x, y, 100, 10, Component.literal(message), onPress, Button.DEFAULT_NARRATION);
        }

        @Override
        public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
            int color = this.isHoveredOrFocused() ? 0x0000FF : 0x404040;
            guiGraphics.drawString(Minecraft.getInstance().font, this.getMessage().getString(), this.getX(), this.getY(), color, false);
        }
    }
}
