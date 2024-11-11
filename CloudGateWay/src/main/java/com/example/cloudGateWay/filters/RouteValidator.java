<<<<<<< HEAD
package com.example.cloudGateWay.filters;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	
	
public static final List<String> openApiEndpoints = List.of("/user/register","/user/login");	
	
	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints
			.stream()
			.noneMatch(uri -> request
								.getURI()
								.getPath()
								.contains(uri));

=======
package com.example.cloudGateWay.filters;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	
	
public static final List<String> openApiEndpoints = List.of("/user/register","/user/login");	
	
	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints
			.stream()
			.noneMatch(uri -> request
								.getURI()
								.getPath()
								.contains(uri));

>>>>>>> 18ad1f04775fdca751e3690a575f15d57128acb3
}