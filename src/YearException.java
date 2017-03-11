
public class YearException extends Exception{
	
	public YearException(){
		super("Error: invalid year");
	}
	
	public YearException(String s){
		super(s);
	}
}
