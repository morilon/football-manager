package com.football.manager.configurations.store.endpoints;

public class MatchStoreEndpoints {
	public static final String API = "/matches";  
	public static final String SAVE = API;
	public static final String DELETE = API + "/{matchId}";
	public static final String GET_INFO = API + "/{matchId}/info";
	public static final String GET_ALL_BY_TEAM = API + "/team/{teamId}";
	public static final String GET_ALL = API;
}
