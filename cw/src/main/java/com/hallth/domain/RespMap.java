package com.hallth.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class RespMap {
    private boolean result;
    private String msg;
    private Map dataMap;
}
