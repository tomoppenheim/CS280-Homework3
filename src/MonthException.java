
public class MonthException extends Exception{
	
	public MonthException(){
		super("Error: Invalid month");
	}
	
	public MonthException(String s){
		super(s);
	}
	
}
