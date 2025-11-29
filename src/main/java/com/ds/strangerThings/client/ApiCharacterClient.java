package com.ds.strangerThings.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ds.strangerThings.dto.ApiCharacterDto;

import java.util.List;

@FeignClient(name = "strangerThings", url = "https://strangerthingsapi.netlify.app/api")
public interface ApiCharacterClient {

    @GetMapping("/characters")
    List<ApiCharacterDto> findAll();

    @GetMapping("/characters/{id}")
    ApiCharacterDto findById(@PathVariable("id") String id);

}
