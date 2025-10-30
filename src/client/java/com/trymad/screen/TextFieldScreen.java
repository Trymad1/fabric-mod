package com.trymad.screen;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class TextFieldScreen extends CottonClientScreen {

	public TextFieldScreen(GuiDescription description) {
		super(description);
	}
	
}
