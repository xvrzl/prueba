package com.ejemploclases.client;

import com.ejemploclases.client.DTO.Tblpersona;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EjemploClases implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	
	VLayout vlayout = new VLayout();
	DynamicForm dynamicForm; 
	TextItem  textnombre;
	TextItem  textcedula;
	TextItem  textdireccion;
	
	public void onModuleLoad() {
		vlayout = new VLayout();
		dynamicForm = new DynamicForm(); 
		textnombre = new TextItem("Nombre", "Nombre");
		textnombre.setTextBoxStyle("n52_sensorweb_client_abo_name_textbox");
		textcedula = new TextItem("Cédula", "Cedula");
		textdireccion = new TextItem("Dirección", "Dirección");
		ButtonItem buttonitemaceptar = new ButtonItem("Enviar");
		buttonitemaceptar.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
			
			public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
				greetingService.settearPersona(callback);
			}
		});
		dynamicForm.setFields(textcedula, textnombre, textdireccion, buttonitemaceptar);
		vlayout.addMember(dynamicForm);
		vlayout.draw();
	}
	 
	final AsyncCallback<Tblpersona>  callback = new AsyncCallback<Tblpersona>(){
		public void onFailure(Throwable caught) {
			SC.say("Error dado:" + caught.toString());
		}
		public void onSuccess(Tblpersona result) {
			SC.say(
				result.getNombre() +
				result.getId() +
				result.getApellido() +
				result.getDireccion()
			);
			dynamicForm.setValue("Cédula", result.getId());
			dynamicForm.setValue("Nombre", result.getNombre() + " " + result.getApellido());
			dynamicForm.setValue("Dirección", result.getDireccion());
		}		
	};	
}