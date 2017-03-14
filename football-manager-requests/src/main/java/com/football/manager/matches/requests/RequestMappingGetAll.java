package com.football.manager.matches.requests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.football.manager.configurations.endpoints.MatchEndpoints;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@RequestMapping(value=MatchEndpoints.GET_ALL, method=RequestMethod.GET)
public @interface RequestMappingGetAll {

}
