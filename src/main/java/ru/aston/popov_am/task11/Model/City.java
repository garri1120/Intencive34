package ru.aston.popov_am.task11.Model;

import java.util.HashSet;
import java.util.Set;

public enum City {
    MOSCOW("0.9"),MINSK("1"),PARIS("0.85");
    private String rateCity;
    City(String rateCity) {
        this.rateCity = rateCity;
    }

    public String getRateCity() {
        return rateCity;
    }
    public static Set<String> getAllCity(){
        Set<String> allCity = new HashSet<>();
        City [] cities = City.values();
        for (City city : cities){
            allCity.add(city.name());
        }
        return allCity;
    }
}
