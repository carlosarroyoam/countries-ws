package com.carlosarroyoam.countries.ws.countries;

import com.carlosarroyoam.ws.countries.GetCountryRequest;
import com.carlosarroyoam.ws.countries.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
  private static final String NAMESPACE_URI = "http://carlosarroyoam.com/ws/countries";
  private CountryRepository countryRepository;

  public CountryEndpoint(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse findByName(@RequestPayload GetCountryRequest request) {
    return countryRepository.findByName(request.getName());
  }
}
