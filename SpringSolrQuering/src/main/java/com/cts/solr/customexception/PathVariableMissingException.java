package com.cts.solr.customexception;

import org.springframework.stereotype.Component;

@Component
public class PathVariableMissingException extends RuntimeException{

	private  String erroeMessage;
	private String errorDetails;
	public String getErroeMessage() {
		return erroeMessage;
	}
	public void setErroeMessage(String erroeMessage) {
		this.erroeMessage = erroeMessage;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public PathVariableMissingException(String erroeMessage, String errorDetails) {
		super();
		this.erroeMessage = erroeMessage;
		this.errorDetails = errorDetails;
	}

	public PathVariableMissingException() {
		
	}
	@Override
	public String toString() {
		return "[" + "\n"
				+ "Message: " + erroeMessage + "\n"+
				"Details: "  + errorDetails + "\n"+
				"]";
	}
	
	
}
