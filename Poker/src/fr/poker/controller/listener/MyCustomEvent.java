package fr.poker.controller.listener;

import java.util.EventObject;

public class MyCustomEvent extends EventObject{
	  //store all relevant info in your event
}

public interface MyListener{
	  public void eventHappened( MyCustomEvent event);	
}