package com.ds.strangerthings.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ds.strangerthings.dto.ApiCharacterDto;

import java.util.List;

@FeignClient(name = "strangerThings", url = "https://hawapi.theproject.id/api/v1/characters/")
public interface ApiCharacterClient {

    @GetMapping
    List<ApiCharacterDto> findAll();

    @GetMapping("/{first_name}")
    ApiCharacterDto findById(@PathVariable("first_name") String first_name);
}
