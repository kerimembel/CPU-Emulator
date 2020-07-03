import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CPU {

	private int AC = 0;
	private int[] M = new int[256];
	private int F = 0;
	private int PC = 0;
	private Boolean halt = false;
	
	private ArrayList<String> program = new ArrayList<String>();
	
	Scanner scan = new Scanner(System.in);
	
	public CPU(){
		
		for (int i = 0; i < M.length; i++) {
			M[i] = 0;
		}	
	}
	
	
	public void Run(){
		
		while(!halt){
			
			processCommand(program.get(PC));
			
		}
		
	}
	
	public void processCommand(String line){
		
		String[] command = line.split(" ");
		if(command.length == 3){
			switch(command[1]){
				case "LOAD":
					
					AC = Integer.parseInt(command[2]);
					PC += 1; 
					break;
					
				case "LOADM":
					
					AC = M[Integer.parseInt(command[2])];
					PC += 1; 
					break;
					
				case "STORE":
					
					M[Integer.parseInt(command[2])] = AC;
					PC += 1; 
					break;
					
				case "CMPM":
					
					if(AC > M[Integer.parseInt(command[2])])
						F = 1;
					else if(AC < M[Integer.parseInt(command[2])])
						F = -1;
					else
						F = 0;
					
					PC += 1;
					
					break;
					
				case "CJMP":
					
					if(F > 0 )
						PC = Integer.parseInt(command[2]);
					else
						PC += 1;
					break;
					
				case "JMP":
					
					PC = Integer.parseInt(command[2]);
					break;
					
				case "ADD":
					
					AC += Integer.parseInt(command[2]);
					PC += 1; 
					break;
					
				case "ADDM":
					
					AC += M[Integer.parseInt(command[2])];
					PC += 1; 
					break;
					
				case "SUBM":
					
					AC -= M[Integer.parseInt(command[2])];
					PC += 1; 
					break;
					
				case "SUB":
					
					AC -= Integer.parseInt(command[2]);
					PC += 1; 
					break;
					
				case "MUL":
					
					AC *= Integer.parseInt(command[2]);
					PC += 1; 
					break;
					
				case "MULM":
					
					AC *= M[Integer.parseInt(command[2])];
					PC += 1; 
					break;
					
				default:
					System.out.println("There is no command like "+command[1]);
			}
				
		}
		else if(command.length == 2){
			
			switch(command[1]){
			
				case "START":
					PC += 1; 
					break;
					
				case "HALT":
					halt = true;
					break;
					
				case "DISP":
					System.out.println(AC);
					PC += 1; 
					break;
			}
			
		}
		
		
	}
	
	
	public void readFile(String filename){
		
		
		try {
		      File file = new File(filename);
		      Scanner reader = new Scanner(file);
		      
		      while (reader.hasNextLine()) {
		        String data = reader.nextLine();
		        program.add(data);
		      }
		      
		      reader.close();
		      
		    } catch (FileNotFoundException e) {
		      System.err.println(filename + " file Not Found!!");
		      
		    }
	}
}
