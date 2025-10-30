package com.trymad;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trymad.network.ServerModNetwork;

public class Trymadmod implements ModInitializer {

	public static final String MOD_ID = "trymad-mod";
	public static final ResourceLocation SEND_MESSAGE_LOCATION = ResourceLocation.fromNamespaceAndPath("trymad", "send_message");

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ServerModNetwork.registerC2SPayloads();
		ServerModNetwork.registerGlobalReceivers();

		LOGGER.info("Hello Fabric world!");

	}
}