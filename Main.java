
public class Main {
	
	
	public static void main(String[] args) {
		
		String filename = "";
		
		if(args.length != 1){
			
			System.err.println("Enter filename!!");
			System.exit(1);
		}
		
		else
			filename = args[0];
		
		CPU cpu = new CPU();
		cpu.readFile(filename);
		cpu.Run();
	}

}
