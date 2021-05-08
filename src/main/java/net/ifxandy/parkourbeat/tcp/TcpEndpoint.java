package net.ifxandy.parkourbeat.tcp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

import net.ifxandy.parkourbeat.proto.Packet;
import net.ifxandy.parkourbeat.service.MessageService;

@MessageEndpoint
public class TcpEndpoint {
	
	private MessageService service;
	
	@Autowired
	public TcpEndpoint(MessageService service) {
		this.service = service;
	}
	
	@ServiceActivator(inputChannel = "inboundChannel")
	public Packet process(Message<Packet> message) {
		
		return service.process(message);
		
	}

}
