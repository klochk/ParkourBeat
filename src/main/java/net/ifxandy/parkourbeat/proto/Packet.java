package net.ifxandy.parkourbeat.proto;

public interface Packet {
	
	Integer id = -1;
	Integer length = -1;
	PacketState state = null;
	Bound bound = null;

}
