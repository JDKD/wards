package com.jdkd.wards.client.renderers;

import com.jdkd.wards.WardConstants;
import com.jdkd.wards.common.tiles.TileEntityWardedBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class TileEntityWardedBlockSpecialRenderer extends TileEntitySpecialRenderer<TileEntityWardedBlock> {

    @Override
    public boolean isGlobalRenderer(TileEntityWardedBlock te) {
        return false;
    }

    @Override
    public void render(TileEntityWardedBlock te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {

        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.translate(0, 0, 0);
        renderBody(te, x, y, z, partialTicks, destroyStage);
        GlStateManager.translate(0, 0, 0);
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void renderBody(TileEntityWardedBlock te, double x, double y, double z, float ticks, int stage){

        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        GlStateManager.pushMatrix();
        GlStateManager.disableLighting();
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();

        World world = getWorld();
        GlStateManager.translate(-te.getPos().getX(), -te.getPos().getY(), -te.getPos().getZ());

        bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);
        BlockRendererDispatcher blockRendererDispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
        blockRendererDispatcher.getBlockModelRenderer().renderModel(
                world,
                blockRendererDispatcher.getModelForState(te.getBlockState()),
                te.getBlockState(),
                te.getPos(),
                bufferbuilder, false);
        tessellator.draw();

        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }
}
