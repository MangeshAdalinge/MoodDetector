package com.hackathon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import oscP5.*;

public class MuseOscServer  {

	static MuseOscServer museOscServer;

	OscP5 museServer;
	static int recvPort = 12000;
	
	

	public static void main(String[] args) {
		museOscServer = new MuseOscServer();
		museOscServer.museServer = new OscP5(museOscServer, recvPort);
	}

	void oscEvent(OscMessage msg) throws IOException {
		System.out.println("### got a message " + msg);
		//bufferedWriter = new BufferedWriter(new FileWriter("c:\\eegData.txt", true));
		if (msg.checkAddrPattern("/muse/eeg") == true) {
			for (int i = 0; i < 4; i++) {
				//bufferedWriter.write("EEG on channel " + i + ": " + msg.get(i).floatValue() + "\n");				
				System.out.print("EEG on channel " + i + ": " + msg.get(i).floatValue() + "\n");
			}
		}
	}

}
