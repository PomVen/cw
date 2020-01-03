package com.hallth.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OaMenuView {
    private String text;
    private String iconCls;
    private String state;
    private List<OaMenuView> children;
    private String onSelect;
    private boolean border;
    private String url;
    private String id;
}
