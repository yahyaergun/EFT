package com.yergun.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Created by yahyaergun on 01/06/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Acquirer {

    private Long id;
    private String name;
    private String code;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
