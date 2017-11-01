package de.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Haup {

    private City city;
    private List<All> list=null;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<All> getList() {
        return list;
    }

    public void setList(List<All> list) {
        this.list = list;
    }
}

