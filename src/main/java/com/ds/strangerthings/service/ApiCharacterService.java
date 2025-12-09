package com.ds.strangerthings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.strangerthings.client.ApiCharacterClient;
import com.ds.strangerthings.dto.ApiCharacterDto;

@Service
public class ApiCharacterService {
    @Autowired private ApiCharacterClient apiCharacterClient;
    public ApiCharacterDto findById(String id) {
        return apiCharacterClient.findById(id);
    }

    public List<ApiCharacterDto> findAll() {
        return apiCharacterClient.findAll();
    }
}
