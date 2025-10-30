package com.trymad.network;

import com.trymad.model.MessageProto.Message;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.resources.ResourceLocation;

public class ClientModNetwork {

	public static final ResourceLocation SEND_MESSAGE_LOCATION = ResourceLocation.fromNamespaceAndPath("trymad", "send_message");

	public static void send(Message message) {
		final MessageC2SPayload payload = new MessageC2SPayload(message);
		ClientPlayNetworking.send(payload);
	}

}
