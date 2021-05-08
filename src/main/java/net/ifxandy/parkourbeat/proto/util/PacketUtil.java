package net.ifxandy.parkourbeat.proto.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PacketUtil {
	
	public static int readVarInt(InputStream stream) throws IOException {
	    int numRead = 0;
	    int result = 0;
	    byte read;
	    do {
	        read = (byte) stream.read();
	        int value = (read & 0b01111111);
	        result |= (value << (7 * numRead));

	        numRead++;
	        if (numRead > 5) {
	            throw new RuntimeException("VarInt is too big");
	        }
	    } while ((read & 0b10000000) != 0);

	    return result;
	}
	
	public static String readString(InputStream stream) throws IOException {
		
		int numRead = 0;
		StringBuilder builder = new StringBuilder();
		int length = readVarInt(stream);
		
		while(numRead < length) {
			
			char next = (char) ((byte) stream.read());
			builder.append(next);
			numRead++;
			
		}
		
		return builder.toString();
		
	}
	
	public static int readUnsignedShort(InputStream stream) throws IOException {
		
		int ch1 = stream.read();
	    int ch2 = stream.read();
	    
	    if ((ch1 | ch2) < 0)
	    	
	        throw new EOFException();
	    
	    return (ch1 << 8) + (ch2 << 0);
		
	}
	
	public static void writeVarInt(int value, OutputStream stream) throws IOException {
	    do {
	        byte temp = (byte)(value & 0b01111111);
	        // Note: >>> means that the sign bit is shifted with the rest of the number rather than being left alone
	        value >>>= 7;
	        if (value != 0) {
	            temp |= 0b10000000;
	        }
	        stream.write(temp);
	    } while (value != 0);
	}
	
	public static String readSizedString(InputStream stream) throws IOException {
        
		int length = readUnsignedShort(stream);
		int numRead = 0;
		StringBuilder builder = new StringBuilder();
		
		while(numRead < length) {
			
			char temp = (char) (byte) stream.read();
			builder.append(temp);
			
			numRead++;
			
		}
		
		return builder.toString();
		
    }

}
