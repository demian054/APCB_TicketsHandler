/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.ticketsHandler.kiuEntities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Demian
 */
@XmlRootElement
public class Meal {
    private String MealCode;

    public String getMealCode() {
        return MealCode;
    }
    @XmlAttribute(name="MealCode")
    public void setMealCode(String mealCode) {
        this.MealCode = mealCode;
    }
     
}
