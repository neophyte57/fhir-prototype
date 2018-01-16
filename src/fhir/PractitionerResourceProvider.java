package fhir;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.hl7.fhir.dstu3.model.PractitionerRole;
import org.hl7.fhir.instance.model.api.IBaseResource;

import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.rest.annotation.IncludeParam;
import ca.uhn.fhir.rest.annotation.OptionalParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.IResourceProvider;

public class PractitionerResourceProvider implements IResourceProvider {

	@Override
	public Class<? extends IBaseResource> getResourceType() {
		// TODO Auto-generated method stub
		return Practitioner.class;
	}

	
	@Search()
	public List<Practitioner> searchByIdentifier(@OptionalParam(name=Practitioner.SP_FAMILY) StringParam familyNameParam,
			@IncludeParam(reverse=true, allow={"PractitionerRole:practitioner"}) Set<Include> theReverseIncludes) {
	    
		List<Practitioner> results = new ArrayList<Practitioner>();

		Practitioner practitioner = new Practitioner();
		practitioner.setId("abc");
		practitioner.addName(new HumanName().setFamily("Proto").addPrefix("Mr."));
		
		PractitionerRole role = new PractitionerRole();
		role.setId("123");
		role.getPractitioner().setResource(practitioner);
		
		results.add(practitioner);
		return results;
    }	
	
	
}
