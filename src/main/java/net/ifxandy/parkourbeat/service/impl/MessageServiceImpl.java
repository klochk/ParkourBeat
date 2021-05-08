package net.ifxandy.parkourbeat.service.impl;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import net.ifxandy.parkourbeat.proto.Packet;
import net.ifxandy.parkourbeat.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public Packet process(Message<Packet> message) {
		
		return null;
		
	}

}
