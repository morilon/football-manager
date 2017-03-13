package com.football.manager.store.teams.requests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.football.manager.configurations.store.endpoints.TeamStoreEndpoints;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@RequestMapping(value=TeamStoreEndpoints.GET_TEAM_NAME, method=RequestMethod.GET)
public @interface RequestMappingGetTeamName {

}
