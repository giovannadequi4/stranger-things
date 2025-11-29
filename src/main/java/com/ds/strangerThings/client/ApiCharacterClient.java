package com.ds.strangerThings.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ds.strangerThings.dto.ApiCharacterDto;

import java.util.List;

@FeignClient(name = "strangerThings", url = "https://hawapi.theproject.id/api/v1/characters/")
public interface ApiCharacterClient {

    @GetMapping
    List<ApiCharacterDto> findAll();

    @GetMapping("/{id}")
    ApiCharacterDto findById(@PathVariable("id") String id);

}
