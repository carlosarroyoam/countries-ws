package com.carlosarroyoam.ws.countries;

import com.carlosarroyoam.ws.config.WebServiceConfig;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
  private final CountryService countryService;

  public CountryEndpoint(CountryService countryService) {
    this.countryService = countryService;
  }

  @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "getCountriesRequest")
  @ResponsePayload
  public GetCountriesResponse findAll(@RequestPayload GetCountriesRequest request) {
    return countryService.findAll();
  }

  @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse findByName(@RequestPayload GetCountryRequest request) {
    return countryService.findByName(request);
  }
}
