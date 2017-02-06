package com.ejemploclases.client;

import com.ejemploclases.client.DTO.Tblpersona;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void settearPersona(AsyncCallback<Tblpersona> callback);
}
