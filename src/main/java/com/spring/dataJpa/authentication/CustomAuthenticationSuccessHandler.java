package com.spring.dataJpa.authentication;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.spring.dataJpa.entities.Users;
import com.spring.dataJpa.repositories.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    
    @Autowired
    public UsersRepository usersRepository;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
           
        HttpSession httpSession=httpServletRequest.getSession();
        httpSession.setAttribute("username", authentication.getName());
        Users users=new Users();
        users=usersRepository.findByUsername(authentication.getName());
        
        httpSession.setAttribute("thanaName",users.getThanaName()); 

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/gdFrom.xhtml");
    }
}
