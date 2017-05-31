package com.yergun.demo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by yahyaergun on 29/05/2017.
 * <p>
 * Intercepts POST requests on the /login path attempt to authenticate the user.
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        Credentials credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(), Credentials.class);

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getEmail(),
                        credentials.getPassword(), Collections.emptyList()));
    }

//    @Override
//    protected void successfulAuthentication(HttpServletRequest req,
//                                            HttpServletResponse res, FilterChain chain,
//                                            Authentication auth) throws IOException, ServletException {
//        TokenAuthService.addAuthentication(res, auth.getName());
//    }

}
