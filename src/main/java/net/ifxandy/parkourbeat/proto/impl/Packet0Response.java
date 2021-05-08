package net.ifxandy.parkourbeat.proto.impl;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ifxandy.parkourbeat.proto.Bound;
import net.ifxandy.parkourbeat.proto.Packet;
import net.ifxandy.parkourbeat.proto.PacketState.HANDSHAKE;

@RequiredArgsConstructor
public class Packet0Response implements Packet {
	
	public static int id = 0x00;
	public static HANDSHAKE state = HANDSHAKE.STATUS;
	public static Bound bound = Bound.CLIENT;
	
	@Getter
	private @NonNull String json;

}
