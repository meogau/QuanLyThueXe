package org.openjfx;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class Dialog {
	private String title, content;
	private AlertType  type;
	public Dialog(String title, String content, AlertType type) {
		this.title = title;
		this.content = content;
		this.type = type;
		log = new Alert(type);
		log.setContentText(content);
		log.setTitle(title);
		log.setHeaderText("");
	}
	
	private Alert log;
	public void show() {
		log.show();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// public abstract void doSomething();
}
