package net.ifxandy.parkourbeat.serializer;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.core.serializer.Serializer;

import net.ifxandy.parkourbeat.proto.Packet;
import net.ifxandy.parkourbeat.proto.impl.Packet0Response;
import net.ifxandy.parkourbeat.proto.util.PacketUtil;

public class PacketSerializer implements Serializer<Packet> {

	@Override
	public void serialize(Packet object, OutputStream outputStream) throws IOException {
		
		if(object instanceof Packet0Response) {
			
			Packet0Response packet = (Packet0Response) object;
			String json = packet.getJson();
			
			System.out.println(json);
			
			PacketUtil.writeVarInt(json.length(), outputStream);
			outputStream.write(json.getBytes());
			
		}
		
	}

}
