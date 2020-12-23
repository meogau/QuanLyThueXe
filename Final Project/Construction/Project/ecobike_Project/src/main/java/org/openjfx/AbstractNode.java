package org.openjfx;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;

public abstract class AbstractNode {
	private AnchorPane mainPane;
	private ProgressIndicator loading;

	public AbstractNode() {
		System.out.println("AbstractNode is creating");
		loading = new ProgressIndicator();
	}

	public void setMainPane(AnchorPane mainPane) {
		this.mainPane = mainPane;
	}

	public AnchorPane getMainPane() {
		return this.mainPane;
	}

	public void onLoading() {
		mainPane.getChildren().add(loading);
		loading.toFront();
		loading.setLayoutX((1000 - loading.getWidth()) / 2);
		loading.setLayoutY((600 - loading.getHeight()) / 2);		
		System.out.println("Loading...");
	}

	private void onLoaded() {

	}
}
