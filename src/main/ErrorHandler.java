package main;

abstract public class ErrorHandler {
	
	private ErrorHandler next;
	
	private Severity severity;
	
	public void setNext(ErrorHandler e){
		next = e;
	}
	
	public ErrorHandler(Severity severity){
		this.severity = severity;
	}
	
	public void error(String error, Severity severity){
		if(severity == this.severity){
			handleError(error);
		}
		else if(next != null){
			next.error(error, severity);
		}
	}
	
	abstract protected void handleError(String error);

}
