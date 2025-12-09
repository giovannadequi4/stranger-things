package com.ds.strangerthings.dto;

import lombok.Data;
import java.util.List;

@Data
public class ApiCharacterDto {

    private String uuid;
    private String first_name;
    private String last_name;
    private String thumbnail;
    private List<String> images;
    private Integer gender;
    private String href;  
    private List<String> sources;
    private String actor;
    private String birth_date;
}
