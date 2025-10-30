package com.trymad.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.resources.ResourceLocation;

public class ServerModNetwork {

	public static final ResourceLocation SEND_MESSAGE_LOCATION = ResourceLocation.fromNamespaceAndPath("trymad", "send_message");
    public static void registerC2SPayloads() {
		PayloadTypeRegistry.playC2S().register(MessageC2SPayload.ID, MessageC2SPayload.CODEC);
    }
	public static final void registerGlobalReceivers() {
		ServerPlayNetworking.registerGlobalReceiver(MessageC2SPayload.ID, (payload, context) -> {
			final String text = payload.message().getText();
			System.out.println(text);
		});
	}

}
