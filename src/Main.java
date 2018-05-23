	import java.io.*; 
	import java.net.*;

import org.json.JSONObject;
import com.google.gson.*;

import Data.User; 

public class Main {

	public static void main(String[] argv) { 

	    try { 
	      ServerSocket serverSocket = new ServerSocket(25565); 
	      Socket clientSocket = serverSocket.accept(); 

	      OutputStream socketoutstr = clientSocket.getOutputStream(); 
	      OutputStreamWriter osr = new OutputStreamWriter( socketoutstr ); 
	      BufferedWriter bw = new BufferedWriter( osr ); 

	      InputStream socketinstr = clientSocket.getInputStream(); 
	      InputStreamReader isr = new InputStreamReader( socketinstr ); 
	      BufferedReader br = new BufferedReader( isr ); 

	      String anfrage; 
	      String antwort; 

	      anfrage = br.readLine(); 
	      antwort = "Antwort auf "+anfrage; 
	      User user = new User();
	      user.setName("peter");
	      user.setPw("peter");
	      Gson gson = new Gson();
	      
	     
	      bw.write(gson.toJson(user)); 
	      bw.newLine(); 
	      bw.flush(); 

	      bw.close(); 
	      br.close(); 
	      clientSocket.close(); 
	      serverSocket.close(); 
	    } 
	    catch (UnknownHostException uhe) { 
	      System.out.println(uhe); 
	    } 
	    catch (IOException ioe) { 
	      System.out.println(ioe); 
	    } 

	  } // ende: main 

	
}
