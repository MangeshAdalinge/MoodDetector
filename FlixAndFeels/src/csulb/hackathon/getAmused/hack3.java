package csulb.hackathon.getAmused;

//package hackwestern;


public class hack3 {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread going to sleep for 1 min");
		
		//Thread.sleep(60000);
		
		System.out.println("Main thread wakes up");
		
		MuseOscServer.practice();
		
		System.out.println("Data capturing ends");
	}

}