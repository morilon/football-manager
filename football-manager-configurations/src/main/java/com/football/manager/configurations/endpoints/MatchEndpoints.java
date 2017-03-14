package com.football.manager.configurations.endpoints;

public class MatchEndpoints {
	public static final String STORE_URL = "http://localhost:6002";
	public static final String API = "/matches";  
	public static final String SAVE = API;
	public static final String DELETE = API + "/{matchId}";
	public static final String GET_BY_ID = API + "/{matchId}";
	public static final String GET_ALL_BY_TEAM = API + "/team/{teamId}";
	public static final String GET_ALL = API;
}
