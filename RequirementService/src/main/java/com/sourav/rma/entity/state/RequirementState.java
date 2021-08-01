/**
 * 
 */
package com.sourav.rma.entity.state;

/**
 * @author dell
 *
 */
public enum RequirementState {
	
	DEPLOYED("Deployed", Actor.DELIVERY_MANAGER),
	VALIDATED("Validated", Actor.QUALITY_ANALYST),
	DEVELOPED("Developed", Actor.DEVELOPER),
	PLANNED("Planned", Actor.PRODUCT_OWNER),
	DESIGNED("Designed", Actor.DEVELOPER),
	REVIEWED("Reviewed", Actor.BUSINESS_ANALYST),
	CANDIDATE("Candidate", Actor.BUSINESS_PROCESS_OWNER),
	SUBMITTED("Submitted", Actor.REQUIREMENT_OWNER),
	DRAFT("Draft", Actor.REQUIREMENT_OWNER);
	
	static {
		DRAFT.setNextState(SUBMITTED);
		SUBMITTED.setNextState(CANDIDATE);
		CANDIDATE.setNextState(REVIEWED);
		REVIEWED.setNextState(DESIGNED);
		DESIGNED.setNextState(PLANNED);
		PLANNED.setNextState(DEVELOPED);
		DEVELOPED.setNextState(VALIDATED);
		VALIDATED.setNextState(DEPLOYED);
		
		DEPLOYED.setPreviousState(VALIDATED);
		VALIDATED.setPreviousState(DEVELOPED);
		DEVELOPED.setPreviousState(PLANNED);
		PLANNED.setPreviousState(DESIGNED);
		DESIGNED.setPreviousState(REVIEWED);
		REVIEWED.setPreviousState(CANDIDATE);
		CANDIDATE.setPreviousState(SUBMITTED);
		SUBMITTED.setPreviousState(DRAFT);
	}
	
	private String stateName;
	private String actor;
	private RequirementState nextState;
	private RequirementState previousState;

	private RequirementState(String stateName, Actor actor) {
		this.stateName = stateName;
		this.actor = actor.getActorName();
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public RequirementState getNextState() {
		return nextState;
	}

	public void setNextState(RequirementState nextState) {
		this.nextState = nextState;
	}

	public RequirementState getPreviousState() {
		return previousState;
	}

	public void setPreviousState(RequirementState previousState) {
		this.previousState = previousState;
	}
	
	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public static RequirementState getRequirementStateByStateName(String stateName) {
		RequirementState reqState = null;
		for(RequirementState state : RequirementState.values()) {
			if(state.getStateName().equalsIgnoreCase(stateName)) {
				reqState = state;
				break;
			}
		}
		return reqState;
	}
	
	public static String getActorForRequirementState(String stateName) {
		String actor = null;
		for(RequirementState state : RequirementState.values()) {
			if(state.getStateName().equalsIgnoreCase(stateName)) {
				actor = state.getActor();
				break;
			}
		}
		return actor;
	}
}
