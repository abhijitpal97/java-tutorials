package com.example.authentication.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.authentication.service.CustomUserDetailservices;
import com.example.authentication.utility.JWTUtility;

import io.jsonwebtoken.security.SignatureException;

@Component
public class JWTFilter extends OncePerRequestFilter{
	
	@Autowired
	JWTUtility jwtUtil;

	@Autowired
	CustomUserDetailservices userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {


		try {

			String authorizationString = request.getHeader("Authorization");
			String token=null;
			String userName=null;
			if(authorizationString !=null && authorizationString.startsWith("Bearer")) {
				token=authorizationString.substring(7);
				userName = jwtUtil.extractUsername(token);
			}

			if(userName !=null && SecurityContextHolder.getContext().getAuthentication() == null )
			{
				UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
				if(Boolean.TRUE.equals(jwtUtil.validateToken(token)))
				{
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
							new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
			filterChain.doFilter(request, response);


		} catch (SignatureException e) {


		}


	
	}

}
