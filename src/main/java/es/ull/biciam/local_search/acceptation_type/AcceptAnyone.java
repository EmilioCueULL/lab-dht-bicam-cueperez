/**
 * @(#) AcceptAnyone.java
 */

package es.ull.biciam.local_search.acceptation_type;

import problem.definition.State;


public class AcceptAnyone extends AcceptableCandidate{

	@Override
	public Boolean acceptCandidate(State stateCurrent, State stateCandidate) {
		Boolean accept = true;
		return accept;
	}
	
}
