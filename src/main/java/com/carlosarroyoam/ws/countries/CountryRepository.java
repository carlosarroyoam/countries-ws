package com.carlosarroyoam.ws.countries;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CountryRepository {
  private static final Map<String, Country> countries = new HashMap<>();

  @PostConstruct
  private void initData() {
    Country spain = new Country();
    spain.setId(1);
    spain.setName("Spain");
    spain.setCapital("Madrid");
    spain.setCurrency(Currency.EUR);
    spain.setPopulation(46704314);
    countries.put(spain.getName().toLowerCase(), spain);

    Country poland = new Country();
    poland.setId(2);
    poland.setName("Poland");
    poland.setCapital("Warsaw");
    poland.setCurrency(Currency.PLN);
    poland.setPopulation(38186860);
    countries.put(poland.getName().toLowerCase(), poland);

    Country uk = new Country();
    uk.setId(3);
    uk.setName("United Kingdom");
    uk.setCapital("London");
    uk.setCurrency(Currency.GBP);
    uk.setPopulation(63705000);
    countries.put(uk.getName().toLowerCase(), uk);
  }

  public GetCountriesResponse findAll() {
    GetCountriesResponse response = new GetCountriesResponse();
    response.countries = new ArrayList<>(countries.values());
    return response;
  }

  public GetCountryResponse findByName(GetCountryRequest request) {
    GetCountryResponse response = new GetCountryResponse();
    response.setCountry(countries.get(request.getName().toLowerCase()));
    return response;
  }
}
