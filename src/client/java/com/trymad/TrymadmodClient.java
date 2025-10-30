package com.trymad;

import com.trymad.screen.TextFieldGuiDescription;
import com.trymad.screen.TextFieldScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.gui.screens.Screen;

public class TrymadmodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		final Screen inputScreen = new TextFieldScreen(new TextFieldGuiDescription());

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            client.setScreen(inputScreen);
        });
	}
}