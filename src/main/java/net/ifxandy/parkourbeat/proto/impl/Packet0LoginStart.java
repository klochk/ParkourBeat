package net.ifxandy.parkourbeat.proto.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ifxandy.parkourbeat.proto.Bound;
import net.ifxandy.parkourbeat.proto.Packet;
import net.ifxandy.parkourbeat.proto.PacketState.HANDSHAKE;
import net.ifxandy.parkourbeat.proto.util.PacketUtil;

@RequiredArgsConstructor
public class Packet0LoginStart implements Packet {
	
	public static int id = 0x00;
	public static HANDSHAKE state = HANDSHAKE.LOGIN;
	public static Bound bound = Bound.SERVER;
	
	@Getter
	private @NonNull String name; 
	
	public static Packet0LoginStart read(byte[] packet) throws IOException {
		
		ByteArrayInputStream stream = new ByteArrayInputStream(packet);
		
		String name = PacketUtil.readSizedString(stream);
		
		return new Packet0LoginStart(name);
		
	}

}
