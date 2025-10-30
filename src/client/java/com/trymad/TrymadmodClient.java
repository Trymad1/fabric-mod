package com.trymad;

import org.lwjgl.glfw.GLFW;

import com.trymad.screen.TextFieldGuiDescription;
import com.trymad.screen.TextFieldScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.KeyMapping;

public class TrymadmodClient implements ClientModInitializer {

	private static KeyMapping keyMapping;
	@Override
	public void onInitializeClient() {
        keyMapping = KeyBindingHelper.registerKeyBinding(new KeyMapping(
			"key.trymad_mod.open_screen", 
			GLFW.GLFW_KEY_M,         
			"key.categories.misc"     
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (keyMapping.consumeClick()) {
				client.setScreen(new TextFieldScreen(new TextFieldGuiDescription())); 
			}
		});

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            client.setScreen(new TextFieldScreen(new TextFieldGuiDescription()));
        });
	}
}