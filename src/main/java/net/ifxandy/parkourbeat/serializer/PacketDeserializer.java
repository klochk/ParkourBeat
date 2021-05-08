package net.ifxandy.parkourbeat.serializer;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.serializer.Deserializer;

import net.ifxandy.parkourbeat.proto.Packet;
import net.ifxandy.parkourbeat.proto.impl.Packet0Login;
import net.ifxandy.parkourbeat.proto.impl.Packet0LoginStart;

public class PacketDeserializer implements Deserializer<Packet> {
	
	@Override
	public Packet deserialize(InputStream inputStream) throws IOException {
		
		int state = 0;
		
		int length = 0;
		byte[] packetData = null;
		int id = 0;
		
		while (inputStream.available() > 0) {
			
			if(state == 0) {
				
				byte[] buff = new byte[1];
				inputStream.read(buff, 0, 1);
				
				length = Byte.toUnsignedInt(buff[0]);
				
				state = 1;
				
			}
			
			if(state == 1) {
				
				packetData = new byte[length];
				inputStream.read(packetData, 0, length);
				
				id = Byte.toUnsignedInt(packetData[0]);
				break;
				
			}
			
		}
		
		Packet packet = null;
		
		if(id == 0x00) {
			
			try {
				
				Packet0Login login = Packet0Login.read(packetData);
				
				if(login == null) {
					throw new RuntimeException("Bad packet0login data received.");
				}
				
				packet = login;
				
			} catch(IOException | RuntimeException ex) {
				
				try {
					
					Packet0LoginStart loginStart = Packet0LoginStart.read(packetData);
					packet = loginStart;
					
				} catch(IOException | RuntimeException ex1) {
					System.out.println("Zay!");
				}
				
			}
			
		}
		
		return packet;
	}

}
