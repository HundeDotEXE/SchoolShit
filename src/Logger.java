import java.util.ArrayList;
import java.util.Map;

public class Logger extends Thread{
	private String name;
	private ArrayList<String> logger;
	private boolean triggerd = false;
	
	
	public Logger(String name) {
		this.name = name;
		logger = new ArrayList<>();
	}
	
	@Override
	public void run() {
		super.run();
		
			for(int i = 0; i < logger.size() ;i++) {
				System.out.println("["+name + "]: "+ logger.get(i));
			}
			logger = new ArrayList<>();
			triggerd = false;
	}
	
	public void print(String string) {
		logger.add(string);
		if(triggerd == false) {
			run();
		}
		triggerd = true;
	}

}
