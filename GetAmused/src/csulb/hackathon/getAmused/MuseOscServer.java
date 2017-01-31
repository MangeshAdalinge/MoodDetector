package csulb.hackathon.getAmused;
//package example;

import oscP5.*;

public class MuseOscServer {

	public static String mood = "";
	static MuseOscServer museOscServer;
	OscP5 museServer;
	static int recvPort = 12000;

	public static void practice() {
		museOscServer = new MuseOscServer();
		museOscServer.museServer = new OscP5(museOscServer, recvPort);
	}

	public void oscEvent(OscMessage msg) {
		float[] values = new float[400000];
		int k = 0;
		EEGDictionary tree = null;
		float average = 0;
		if (msg.checkAddrPattern("/muse/eeg") == true) {
			for (int j = 0; j < 100000; j++) {
				for (int i = 0; i < 4; i++) {
					values[k] = msg.get(i).floatValue();
					k++;
					// System.out.print("EEG on channel " + i + ": " +
					// msg.get(i).floatValue() + "\n");
				}
			}
			
			for (int i = 0; i < values.length; i++) {
				average = average + values[i];
			}
			average = average / values.length;
			System.out.println("AVERAGE:" + average);

			tree = new EEGDictionary();
			System.out.println("Average is : "+average);
			mood = tree.getMyMood(average);
			System.out.println("123 Mood is : "+mood);
			
			museOscServer.museServer.stop();

			// id = tree.getGenreId(average);
			/*
			 * for (int i = 0; i < id.length; i++) { System.out.println("ID: " +
			 * id[i]); } MovieGenre print = new MovieGenre();
			 * print.printGenre(id);
			 */

			// museOscServer.museServer.stop();
		}
		//return tree.getMyMood(average);

	}
}
