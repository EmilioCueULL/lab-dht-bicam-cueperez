/**
 * @(#) AleatoryCandidate.java
 */

package local_search.candidate_type;

import java.util.List;

import problem.definition.State;

import java.security.SecureRandom;

public class RandomCandidate extends SearchCandidate {

	@Override
	public State stateSearch(List<State> listNeighborhood) {
		SecureRandom secure = new SecureRandom();
		int pos = (int)(secure.nextDouble() * (double)(listNeighborhood.size() - 1));
		State stateAleatory = listNeighborhood.get(pos);
		return stateAleatory;
	}
}
