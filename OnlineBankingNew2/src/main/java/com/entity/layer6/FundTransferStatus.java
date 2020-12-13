package com.entity.layer6;

public class FundTransferStatus {
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public type getStatus() {
		return status;
	}

	public void setStatus(type status) {
		this.status = status;
	}

	private String message;
	
	
    public static enum type{
    	
    	successfullycompleted, oopstryagain;
    }

    private type status;
    
    
}
