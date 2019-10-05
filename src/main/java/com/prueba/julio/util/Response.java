package com.prueba.julio.util;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable{
	private static final long serialVersionUID = 1L;
	private Boolean success;
    private List<String> error;
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public List<String> getError() {
		return error;
	}

	public void setError(List<String> error) {
		this.error = error;
	}
    
}
