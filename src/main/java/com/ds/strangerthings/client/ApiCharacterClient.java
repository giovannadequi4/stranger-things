package com.ds.strangerthings.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ds.strangerthings.dto.ApiCharacterDto;

import java.util.List;

@FeignClient(name = "strangerThings", url = "https://hawapi.theproject.id/api/v1/characters/")
public interface ApiCharacterClient {

    @GetMapping
    List<ApiCharacterDto> findAll();
}
