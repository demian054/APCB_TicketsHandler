/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuPrincipalEntities;

import com.apcb.utils.xml.XmlParser;


/**
 *
 * @author Demian
 */
public class KIUMainRequest {
    String user;
    String password;
    Class  requestClass;
    Object request;

    public KIUMainRequest(Class requestClass) {
        this.requestClass = requestClass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

 
    
 
    @Override
    public String toString() {
        return new StringBuilder()
                .append("user=").append(user)
                .append("&password=").append(password)
                .append("&request=").append(XmlParser.toXML(request, requestClass))
                .toString();
    }
    
    
    
    
    
}
