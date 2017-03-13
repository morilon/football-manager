package com.football.manager.store.matches.requests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.football.manager.configurations.store.endpoints.MatchStoreEndpoints;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@RequestMapping(value=MatchStoreEndpoints.GET_INFO, method=RequestMethod.GET)
public @interface RequestMappingGetInfo {

}
