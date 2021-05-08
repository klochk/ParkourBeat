package net.ifxandy.parkourbeat.service;

import org.springframework.messaging.Message;

import net.ifxandy.parkourbeat.proto.Packet;

public interface MessageService {

	Packet process(Message<Packet> message);

}
