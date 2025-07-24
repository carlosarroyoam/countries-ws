package com.carlosarroyoam.ws.countries;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
  private static final String NAMESPACE_URI = "http://carlosarroyoam.com/ws/countries";
  private final CountryRepository countryRepository;

  public CountryEndpoint(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountriesRequest")
  @ResponsePayload
  public GetCountriesResponse findAll(@RequestPayload GetCountriesRequest request) {
    return countryRepository.findAll();
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse findByName(@RequestPayload GetCountryRequest request) {
    return countryRepository.findByName(request);
  }
}
