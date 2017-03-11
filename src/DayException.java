
public class DayException extends Exception{
	public DayException(){
		super("Error: invalid day");
	}
	
	public DayException(String s){
		super(s);
	}
}
