package com.iktpreobuka.securityexamplebasic.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void afterPropertiesSet() {
        this.setRealmName("DeveloperStack");
        super.afterPropertiesSet();
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
		// postavljamo zaglavlje
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
		// postavljamo status
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		// pišemo proizvoljnu poruku
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 -" + authException.getMessage());
    }
}