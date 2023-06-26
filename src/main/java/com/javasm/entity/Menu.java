package com.javasm.entity;


import java.util.List;

public class Menu {

  private long menuId;
  private String menuName;
  private long parentId;
  private String menuUrl;
  private String glyphicon;
  private long versionId;

  //二级菜单
  private List<Menu> subMenu;


  public long getMenuId() {
    return menuId;
  }

  public void setMenuId(long menuId) {
    this.menuId = menuId;
  }


  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getMenuUrl() {
    return menuUrl;
  }

  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
  }




  public String getGlyphicon() {
    return glyphicon;
  }

  public void setGlyphicon(String glyphicon) {
    this.glyphicon = glyphicon;
  }


  public long getVersionId() {
    return versionId;
  }

  public void setVersionId(long versionId) {
    this.versionId = versionId;
  }

  @Override
  public String toString() {
    return "Menu{" +
            "menuId=" + menuId +
            ", menuName='" + menuName + '\'' +
            ", parentId=" + parentId +
            ", menuUrl='" + menuUrl + '\'' +
            ", glyphicon='" + glyphicon + '\'' +
            ", versionId=" + versionId +
            ", subMenu=" + subMenu +
            '}';
  }
}
