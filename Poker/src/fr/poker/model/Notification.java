package fr.poker.model;

public class Notification {
	private String message;

	public Notification(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "[NOTIF] " + message;
	}
	
	
}