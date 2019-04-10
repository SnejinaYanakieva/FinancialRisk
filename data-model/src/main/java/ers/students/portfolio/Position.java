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
 * A position is the amount of a security, commodity or currency which is owned
 * by an individual, dealer, institution, or other fiscal entity.
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

    public Position(String id, String name, String shortSide, String longSide, String portfolioId, Instrument instrument) {
        this.id = id;
        this.name = name;
        this.shortSide = shortSide;
        this.longSide = longSide;
        this.portfolioId = portfolioId;
        this.instrument = instrument;
    }

    public Position() {
    }

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
    public boolean equals(Object obj) {
        Position object = (Position) obj;
        return this.id.equals(object.id)
                && this.name.equals(object.name)
                && this.shortSide.equals(object.shortSide)
                && this.longSide.equals(object.longSide)
                && this.portfolioId.equals(object.portfolioId)
                && this.instrument.equals(object.instrument);
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

        if (shortSide == null || "".equals(shortSide)) {

            validationList.add("shortSide is invalid");

        }

        if (longSide == null || "".equals(longSide)) {

            validationList.add("longSide is invalid");
        }

        if (shortSide.equals(longSide)) {
            validationList.add("shortSide and longSide should not be the same");

        }
        //portfolioId
        if (portfolioId == null || "".equals(portfolioId)) {

            validationList.add("portfolioId is invalid");
        }
        //instrument         
        if (instrument == null) {

            validationList.add("instrument is null");
        }

        if (!(instrument.validate().isEmpty())) {

            validationList.add("instrument is not valid");

        }

        return validationList;
    }
}
