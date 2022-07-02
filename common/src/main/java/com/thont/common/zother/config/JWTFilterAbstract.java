package com.thont.common.zother.config;

import com.thont.common.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public abstract class JWTFilterAbstract extends OncePerRequestFilter implements Filter {
    @Autowired private JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader("Authorization");
        if(jwtToken != null && jwtToken.startsWith("Bearer ")){
            String id = jwtService.getUsernameFromToken(jwtToken.substring(7, jwtToken.length()));
            UserDetails user = getUserWithRoleById(id);
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(new UsernamePasswordAuthenticationToken(user,
                            null,
                            user.getAuthorities()));
        }
        filterChain.doFilter(request, response);
    }

    protected abstract UserDetails getUserWithRoleById(String email);

}
