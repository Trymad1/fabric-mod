package com.trymad.network;

import com.google.protobuf.InvalidProtocolBufferException;
import com.trymad.model.MessageProto;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record MessageC2SPayload(MessageProto.Message message) implements CustomPacketPayload {

	public static final StreamCodec<RegistryFriendlyByteBuf, MessageC2SPayload> CODEC = StreamCodec.of(
		(buf, payload) -> buf.writeByteArray(payload.message.toByteArray()),
		buf -> {
            byte[] bytes = buf.readByteArray();
			return MessageC2SPayload.decodePayload(bytes);
		});

	public static final CustomPacketPayload.Type<MessageC2SPayload> ID = new CustomPacketPayload.Type<>(ServerModNetwork.SEND_MESSAGE_LOCATION);
	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ID;
	}

	private static final MessageC2SPayload decodePayload(byte[] bytes) {
		MessageProto.Message msg;
		try {
			msg = MessageProto.Message.parseFrom(bytes);
		} catch (InvalidProtocolBufferException e) {
			throw new RuntimeException(e);
		}
        return new MessageC2SPayload(msg);
	}
	
}
