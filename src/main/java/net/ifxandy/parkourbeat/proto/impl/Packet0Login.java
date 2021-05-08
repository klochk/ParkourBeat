package net.ifxandy.parkourbeat.proto.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ifxandy.parkourbeat.proto.Bound;
import net.ifxandy.parkourbeat.proto.Packet;
import net.ifxandy.parkourbeat.proto.PacketState;
import net.ifxandy.parkourbeat.proto.PacketState.HANDSHAKE;
import net.ifxandy.parkourbeat.proto.util.PacketUtil;

@RequiredArgsConstructor
public class Packet0Login implements Packet {
	
	public static int id = 0x00;
	public static PacketState state = PacketState.HANDSHAKE;
	public static Bound bound = Bound.SERVER;
	
	@Getter
	public @NonNull Integer protocolVersion;
	
	@Getter
	public @NonNull String hostName;
	
	@Getter
	public @NonNull Integer port;
	
	@Getter
	public @NonNull HANDSHAKE nextState;
	
	@Getter
	public @NonNull Integer length;

	public static Packet0Login read(byte[] packet) throws IOException {
		
		byte[] data = Arrays.copyOfRange(packet, 1, packet.length);
		ByteArrayInputStream stream = new ByteArrayInputStream(data);
		
		int length = stream.available();
		
		if(length <= 0) {
			return null;
		}
		
		int protoVersion = PacketUtil.readVarInt(stream);
		String hostname = PacketUtil.readString(stream);
		int port = PacketUtil.readUnsignedShort(stream);
		int next = PacketUtil.readVarInt(stream);
		
		HANDSHAKE nextEnum = null;
		
		if(next == 1) {
			nextEnum = HANDSHAKE.STATUS;
		} else {
			nextEnum = HANDSHAKE.LOGIN;
		}
		
		if(nextEnum == null) {
			System.err.println("Invalid Next State of Handshake Packet");
			throw new RuntimeException("Invalid Next State of Handshake Packet");
		}
		
		return new Packet0Login(protoVersion, hostname, port, nextEnum, length);
		
	}

}
