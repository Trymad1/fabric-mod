package com.trymad;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trymad.network.ServerModNetwork;
import com.trymad.util.HibernateUtil;

public class Trymadmod implements ModInitializer {

	public static final String MOD_ID = "trymad-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		HibernateUtil.connect();
		ServerModNetwork.registerC2SPayloads();
		ServerModNetwork.registerGlobalReceivers();
	}
}