package com.devManzutti.DBFootball.resource.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant Timestamp;
	private Integer Status;
	private String Error;
	private String Message;
	private String Path;
	
	public StandardError() {
	}

	public Instant getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		Timestamp = timestamp;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}
}
