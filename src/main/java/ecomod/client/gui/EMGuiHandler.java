package ecomod.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import ecomod.common.tiles.TileAnalyzer;
import ecomod.core.EMConsts;
import ecomod.core.EcologyMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EMGuiHandler implements IGuiHandler {
	
	public EMGuiHandler()
	{
		
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == EMConsts.analyzer_gui_id)
		{
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null)
			{
				if(te instanceof TileAnalyzer)
				return new GuiAnalyzer((TileAnalyzer)te);
			}
			else
			{
				EcologyMod.log.error("Unable to open GuiAnalyzer!!! TileEntity not found!");
				return null;
			}
		}
		
		return null;
	}

}
