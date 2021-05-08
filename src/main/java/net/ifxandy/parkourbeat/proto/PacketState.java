package net.ifxandy.parkourbeat.proto;

import lombok.Getter;

public enum PacketState {
	
	HANDSHAKE,
	PLAY;
	
	public enum HANDSHAKE {
		
		STATUS(1),
		LOGIN(2);
		
		@Getter
		private int code;
		
		HANDSHAKE(int code) {
			this.code = code;
		}
		
	};

}
