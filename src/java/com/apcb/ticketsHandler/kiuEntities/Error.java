/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement(name="Error")
public class Error {
    String ErrorCode;
    String ErrorMsg;

    public String getErrorCode() {
        return ErrorCode;
    }
    @XmlElement(name="ErrorCode")
    public void setErrorCode(String errorCode) {
        this.ErrorCode = errorCode;
    }

    public String getErrorMsg() {
        return ErrorMsg;
    }
    @XmlElement(name="ErrorMsg")
    public void setErrorMsg(String ErrorMsg) {
        this.ErrorMsg = ErrorMsg;
    }
    
    
    
}
