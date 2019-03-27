/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.portfolio;

import ers.students.instruments.Instrument;
import ers.students.validate.Validatable;
import java.util.ArrayList;
import java.util.List;

/**
 * Is about who gives money to who and the instrument
 *
 * @author Viktor
 */
public class Position implements Validatable {

    private String id;
    private String name;
    private String shortSide;
    private String longSide;
    private String portfolioId;
    private Instrument instrument;

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortSide() {
        return shortSide;
    }

    public void setShortSide(String shortSide) {
        this.shortSide = shortSide;
    }

    public String getLongSide() {
        return longSide;
    }

    public void setLongSide(String longSide) {
        this.longSide = longSide;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    @Override
    public List<String> validate() {
        List<String> validationList = new ArrayList<>();
        validationList.addAll(instrument.validate());
        //ID 
        if (id == null || "".equals(id)) {

            validationList.add("id is invalid");
        }

        if (name == null || "".equals(name)) {

            validationList.add("name is invalid");
        }

        //shortSide
        if (shortSide.equals(longSide)) {
            validationList.add("shortSide and longSide should not be the same");

        }
        if (shortSide == null || "".equals(shortSide)) {

            validationList.add("shortSide is invalid");

        }

        //longSide
        if (longSide == null || "".equals(longSide)) {

            validationList.add("longSide is invalid");
        }

        //portfolioId
        if (portfolioId == null || "".equals(portfolioId)) {

            validationList.add("portfolioId is invalid");
        }
        //instrument         
        if (instrument == null) {

            validationList.add("instrument is null");
        }

        return validationList;
    }
}
