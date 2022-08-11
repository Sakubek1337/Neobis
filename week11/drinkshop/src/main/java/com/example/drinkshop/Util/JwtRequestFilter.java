package com.example.drinkshop.Util;

import com.example.drinkshop.Security.MyUserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    MyUserService jwtUserDetailsService;
    @Autowired
    JwtUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");
        if (requestTokenHeader != null) {
            String jwtToken = requestTokenHeader;
            try {
                String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                if (StringUtils.isNotEmpty(username)
                        && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
                    if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken
                                .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext()
                                .setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
            } catch (IllegalArgumentException e) {
                logger.error("Unable to fetch JWT Token");
            } catch (ExpiredJwtException e) {
                logger.error("JWT Token is expired");
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("JWT Token does begin with Bearer String");
        }
        chain.doFilter(request, response);
    }

}
