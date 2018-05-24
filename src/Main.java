	import java.io.*; 
	import java.net.*;

import javax.jws.soap.SOAPBinding.Use;

import org.json.JSONObject;
import com.google.gson.*;

import Data.User; 



public class Main {
	
	static Logger logger;

	public static void main(String[] argv) { 
		logger = new Logger("Server");
		while(true) {
		     HanelConn();
		}

	  } 
	
	public static void HanelConn() {
		try { 
		
	    	ServerSocket serverSocket = new ServerSocket(25565); 
	    	Socket clientSocket = serverSocket.accept(); 

		      OutputStream socketoutstr = clientSocket.getOutputStream(); 
		      OutputStreamWriter osr = new OutputStreamWriter( socketoutstr ); 
		      BufferedWriter bw = new BufferedWriter( osr ); 

		      InputStream socketinstr = clientSocket.getInputStream(); 
		      InputStreamReader isr = new InputStreamReader( socketinstr ); 
		      BufferedReader br = new BufferedReader( isr ); 

		      String anfrage = br.readLine(); 
		     
		      
		     switch(anfrage){
		     case "testDB":
		    	 logger.print("DN");
		    	 bw.write("HALLO");
		    	 break;
		     }
		     
		      //bw.write(gson.toJson(Obj)); //Abschicken
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

	}

}
