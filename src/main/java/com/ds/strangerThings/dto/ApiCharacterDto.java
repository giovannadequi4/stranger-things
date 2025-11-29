package com.ds.strangerThings.dto;

import lombok.Data;
import java.util.List;

@Data
public class ApiCharacterDto {

    private String _id;
    private List<String> aliases;
    private List<String> otherRelations;
    private List<String> affiliation;
    private List<String> occupation;
    private List<String> residence;
    private List<String> appearsInEpisodes;
    private String photo;
    private String name;
    private String status;
    private String gender;
    private String eyeColor;
    private String portrayedBy;
}
