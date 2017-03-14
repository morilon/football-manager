package com.football.manager.teams.requests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.football.manager.configurations.endpoints.TeamEndpoints;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@RequestMapping(value=TeamEndpoints.GET_BY_ID, method=RequestMethod.GET)
public @interface RequestMappingGetById {

}
