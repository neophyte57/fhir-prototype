package fhir;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import ca.uhn.fhir.rest.server.RestfulServer;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.server.IResourceProvider;

//@WebServlet(urlPatterns= {"/prototype/*"}, displayName="FHIR Server")
public class MyRestfulServer extends RestfulServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 771544608972526264L;


	public MyRestfulServer() {
		
		super(FhirContext.forDstu3()); 
	}

	
	@Override
	protected void initialize() throws ServletException {
		/*
		 * The servlet defines any number of resource providers, and
		 * configures itself to use them by calling
		 * setResourceProviders()
		 */
		List<IResourceProvider> resourceProviders = new ArrayList<IResourceProvider>();
		resourceProviders.add(new PractitionerResourceProvider());
		setResourceProviders(resourceProviders);
	}	
	
	
}
