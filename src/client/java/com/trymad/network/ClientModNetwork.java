package com.trymad.network;

import com.trymad.model.MessageProto.Message;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

@Environment(EnvType.CLIENT)
public class ClientModNetwork {

	public static void send(Message message) {
		final MessageC2SPayload payload = new MessageC2SPayload(message);
		ClientPlayNetworking.send(payload);
	}

}
