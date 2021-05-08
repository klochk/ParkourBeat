package net.ifxandy.parkourbeat.proto.impl;

import net.ifxandy.parkourbeat.proto.Bound;
import net.ifxandy.parkourbeat.proto.Packet;
import net.ifxandy.parkourbeat.proto.PacketState.HANDSHAKE;

public class Packet0Request implements Packet {
	
	public static int id = 0x00;
	public static HANDSHAKE state = HANDSHAKE.STATUS;
	public static Bound bound = Bound.SERVER;
	
	public static Packet0Request read(byte[] packet) {
		
		return new Packet0Request();
		
	}

}
