package org.belowski.weather.model.forecast;

import javax.xml.bind.annotation.XmlAttribute;

import org.belowski.weather.model.WeatherNumber;
import org.belowski.weather.model.WeatherNumber.ConditionType;

public class Symbol {
    
    private ConditionType conditionType;

    private int number;

    private String name;

    private String var;
    
    public static Symbol generate(float rainAmount, int visibility, int clouds) {
        return new Symbol(WeatherNumber.getConditionType(rainAmount, visibility, clouds), "auto generated", "01d"); 
    }

    public Symbol() {
        super();
    }

    public Symbol(ConditionType conditionType) {
        super();
        this.conditionType = conditionType;
        this.number = WeatherNumber.CONDITION_IDS.get(conditionType);
    }
    
    private Symbol(ConditionType conditionType, String name, String var) {
        super();
        this.conditionType = conditionType;
        this.number = WeatherNumber.CONDITION_IDS.get(conditionType);
        this.name = name;
        this.var = var;
    }

    @XmlAttribute
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }
}
