/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.market;

import ers.students.validate.Validatable;
import java.util.ArrayList;
import java.util.List;

/**
 * YieldCurve shows the yield at periods.
 *
 * @author Viktor
 */
public class YieldCurve implements Validatable {

    private String id;
    private String name;
    private double yield1month;
    private double yield2month;
    private double yield3month;
    private double yield6month;
    private double yield1year;
    private double yield2year;
    private double yield5year;
    private double yield10year;
    private double yield20year;
    private double yield30year;

    public YieldCurve() {
    }

    public YieldCurve(String id, String name, double yield1month, double yield2month, double yield3month, double yield6month, double yield1year, double yield2year, double yield5year, double yield10year, double yield20year, double yield30year) {
        this.id = id;
        this.name = name;
        this.yield1month = yield1month;
        this.yield2month = yield2month;
        this.yield3month = yield3month;
        this.yield6month = yield6month;
        this.yield1year = yield1year;
        this.yield2year = yield2year;
        this.yield5year = yield5year;
        this.yield10year = yield10year;
        this.yield20year = yield20year;
        this.yield30year = yield30year;
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

    public double getYield1month() {
        return yield1month;
    }

    public void setYield1month(double yield1month) {
        this.yield1month = yield1month;
    }

    public double getYield2month() {
        return yield2month;
    }

    public void setYield2month(double yield2month) {
        this.yield2month = yield2month;
    }

    public double getYield3month() {
        return yield3month;
    }

    public void setYield3month(double yield3month) {
        this.yield3month = yield3month;
    }

    public double getYield6month() {
        return yield6month;
    }

    public void setYield6month(double yield6month) {
        this.yield6month = yield6month;
    }

    public double getYield1year() {
        return yield1year;
    }

    public void setYield1year(double yield1year) {
        this.yield1year = yield1year;
    }

    public double getYield2year() {
        return yield2year;
    }

    public void setYield2year(double yield2year) {
        this.yield2year = yield2year;
    }

    public double getYield5year() {
        return yield5year;
    }

    public void setYield5year(double yield5year) {
        this.yield5year = yield5year;
    }

    public double getYield10year() {
        return yield10year;
    }

    public void setYield10year(double yield10year) {
        this.yield10year = yield10year;
    }

    public double getYield20year() {
        return yield20year;
    }

    public void setYield20year(double yield20year) {
        this.yield20year = yield20year;
    }

    public double getYield30year() {
        return yield30year;
    }

    public void setYield30year(double yield30year) {
        this.yield30year = yield30year;
    }

    public List<String> validateYield() {
        List<String> validationList = new ArrayList<>();

        if (yield1month < 0 || yield1month > 100) {
            validationList.add("The Yield for 1 month is invalid");
        }
        if (yield2month < 0 || yield2month > 100) {
            validationList.add("The Yield for 2 month is invalid");
        }
        if (yield3month < 0 || yield3month > 100) {
            validationList.add("The Yield for 3 month is invalid");
        }
        if (yield6month < 0 || yield6month > 100) {
            validationList.add("The Yield for 6 month is invalid");
        }
        if (yield1year < 0 || yield1year > 100) {
            validationList.add("The Yield for 1 year is invalid");
        }
        if (yield2year < 0 || yield2year > 100) {
            validationList.add("The Yield for 2 year is invalid");
        }
        if (yield5year < 0 || yield5year > 100) {
            validationList.add("The Yield for 5 year is invalid");
        }
        if (yield10year < 0 || yield10year > 100) {
            validationList.add("The Yield for 10 year is invalid");
        }
        if (yield20year < 0 || yield20year > 100) {
            validationList.add("The Yield for 20 year is invalid");
        }
        if (yield30year < 0 || yield30year > 100) {
            validationList.add("The Yield for 30 year is invalid");
        }

        return validationList;
    }

    @Override
    public List<String> validate() {
        List<String> validationList = new ArrayList<>();
        if (id == null || "".equals(id)) {

            validationList.add("id is invalid");
        }

        if (name == null || "".equals(name)) {

            validationList.add("name is invalid");
        }
        validationList.addAll(validateYield());
        
        return validationList;
    }
}
