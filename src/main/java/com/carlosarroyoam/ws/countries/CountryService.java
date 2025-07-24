package com.carlosarroyoam.ws.countries;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CountryService {
  private final CountryRepository countryRepository;

  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  public GetCountriesResponse findAll() {
    return countryRepository.findAll();
  }

  public GetCountryResponse findByName(GetCountryRequest request) {
    Assert.notNull(request.getName(), "The country's name must not be null");
    return countryRepository.findByName(request);
  }
}
