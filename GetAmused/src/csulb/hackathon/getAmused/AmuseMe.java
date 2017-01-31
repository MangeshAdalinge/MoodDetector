package csulb.hackathon.getAmused;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import oscP5.OscMessage;
import oscP5.OscP5;

public class AmuseMe extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String myMood = "";

		System.out.println("Code to analyze the captured data is called");	
		
		hack3 hack3 = new hack3();
		try {
			hack3.getMyMood();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myMood = MuseOscServer.mood;
		System.out.println("Mood is : "+myMood);
		
		/*System.out.println();*/
		while (myMood == "") {
			System.out.println("In while loop");
			myMood = MuseOscServer.mood;
		}
		
		request.getSession().setAttribute("mood", myMood);
		String str = "sad";
		RequestDispatcher dispatchResponse = request.getRequestDispatcher("index_m.jsp");
		
		
		PrintWriter out = response.getWriter();
		out.print(str);
		dispatchResponse.forward(request, response);
	}
}
