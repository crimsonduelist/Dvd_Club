/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nameit3.shiro.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.Facelet;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author WiZ14
 */
@Named
@SessionScoped
public class UserController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public UserController() {
//    }

    public void doAuth() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            System.out.println("already authed");
        } else if (!subject.isAuthenticated()) {
            try {
                        System.out.println("dologin1");
                UsernamePasswordToken UPToken = new UsernamePasswordToken(getUsername(), getPassword());
                        System.out.println("dologin2");
                doAuthHelper(subject, UPToken);
            } catch (UnknownAccountException ex) {
                log.error(ex.getMessage(), ex);
            } catch (IncorrectCredentialsException ex) {
                log.error(ex.getMessage(), ex);
            } catch (LockedAccountException ex) {
                log.error(ex.getMessage(), ex);
            } catch (AuthenticationException ex) {
                log.error(ex.getMessage(), ex);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void doAuthHelper(Subject subject, UsernamePasswordToken UPToken) throws IOException {
                System.out.println("helper");
        subject.login(UPToken);
        if (subject.isAuthenticated()) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context
                    .getExternalContext()
                    .getResponse();
            if (subject.hasRole("ADMIN")) {
                System.out.println("admin page");
                response.sendRedirect("admin/welcome.xhtml");

            } else if (subject.hasRole("USER")) {
                System.out.println("user page");
                response.sendRedirect("user/user.xhtml");

            }
        }
    }

    public void doLogout() throws IOException {
        System.out.println("dologout");
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            System.out.println("logged out");
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context
                    .getExternalContext()
                    .getResponse();
            response.sendRedirect("main.xhtml");
        } else if (!subject.isAuthenticated()) {
            System.out.println("not authed");
        }
    }

    public void testm() {
        System.out.println("JSF API Location: " + FacesContext.class.getProtectionDomain().getCodeSource());
        System.out.println("JSF Impl Location: " + Facelet.class.getProtectionDomain().getCodeSource());
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
InputStream input = externalContext.getResourceAsStream("/resources/movies.xml");
    }
}
