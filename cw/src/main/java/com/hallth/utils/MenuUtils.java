package com.hallth.utils;

import com.hallth.domain.OaMenu;
import com.hallth.domain.OaMenuView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuUtils {
    public List<OaMenuView> getMenuView(List<OaMenu> oaMenuList) {
        List<OaMenuView> list = new ArrayList<>();
        for(OaMenu menu : oaMenuList){
            if(menu.getParentId().equals("0")){
                OaMenuView oaMenuView = new OaMenuView();
                oaMenuView.setText(menu.getMenuName());
                oaMenuView.setIconCls(menu.getMenuIcon());
                oaMenuView.setUrl(menu.getMenuPath());
                oaMenuView.setState("open");
                oaMenuView.setBorder(true);
//                oaMenuView.setOnSelect("onSelect");
                oaMenuView.setId(menu.getMenuId());
                List<OaMenuView> l = getChildrenList(oaMenuList, menu.getMenuId());
                if(l != null && l.size()>0){
                    oaMenuView.setChildren(getChildrenList(oaMenuList, menu.getMenuId()));
                }
                list.add(oaMenuView);
            }
        }
        return list;
    }

    private List<OaMenuView> getChildrenList(List<OaMenu> oaMenuList, String menuId) {
        List<OaMenuView> list = new ArrayList<>();
        for(OaMenu menu : oaMenuList){
            if(menu.getParentId().equals(menuId)){
                OaMenuView oaMenuView = new OaMenuView();
                oaMenuView.setText(menu.getMenuName());
                oaMenuView.setIconCls(menu.getMenuIcon());
                oaMenuView.setUrl(menu.getMenuPath());
                oaMenuView.setState("open");
                oaMenuView.setBorder(true);
//                oaMenuView.setOnSelect("onSelect");
                oaMenuView.setId(menu.getMenuId());
                List<OaMenuView> l = getChildrenList(oaMenuList, menu.getMenuId());
                if(l != null && l.size()>0){
                    oaMenuView.setChildren(getChildrenList(oaMenuList, menu.getMenuId()));
                }
                list.add(oaMenuView);
            }
        }
        return list;
    }
}
