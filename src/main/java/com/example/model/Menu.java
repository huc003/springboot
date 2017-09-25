package com.example.model;

import java.io.Serializable;

public class Menu implements Serializable {
    private Integer id;

	private String menuId;

	private String menuName;

	private Integer upperLevel;

	private String url;

	private String code;

	private Integer sort;

	private String icon;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId == null ? null : menuId.trim();
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	public Integer getUpperLevel() {
		return upperLevel;
	}

	public void setUpperLevel(Integer upperLevel) {
		this.upperLevel = upperLevel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Menu other = (Menu) that;
		return (this.getId() == null ? other.getId() == null : this.getId()
				.equals(other.getId()))
				&& (this.getMenuId() == null ? other.getMenuId() == null : this
						.getMenuId().equals(other.getMenuId()))
				&& (this.getMenuName() == null ? other.getMenuName() == null
						: this.getMenuName().equals(other.getMenuName()))
				&& (this.getUpperLevel() == null ? other.getUpperLevel() == null
						: this.getUpperLevel().equals(other.getUpperLevel()))
				&& (this.getUrl() == null ? other.getUrl() == null : this
						.getUrl().equals(other.getUrl()))
				&& (this.getCode() == null ? other.getCode() == null : this
						.getCode().equals(other.getCode()))
				&& (this.getSort() == null ? other.getSort() == null : this
						.getSort().equals(other.getSort()))
				&& (this.getIcon() == null ? other.getIcon() == null : this
						.getIcon().equals(other.getIcon()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result
				+ ((getMenuId() == null) ? 0 : getMenuId().hashCode());
		result = prime * result
				+ ((getMenuName() == null) ? 0 : getMenuName().hashCode());
		result = prime * result
				+ ((getUpperLevel() == null) ? 0 : getUpperLevel().hashCode());
		result = prime * result
				+ ((getUrl() == null) ? 0 : getUrl().hashCode());
		result = prime * result
				+ ((getCode() == null) ? 0 : getCode().hashCode());
		result = prime * result
				+ ((getSort() == null) ? 0 : getSort().hashCode());
		result = prime * result
				+ ((getIcon() == null) ? 0 : getIcon().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", menuId=").append(menuId);
		sb.append(", menuName=").append(menuName);
		sb.append(", upperLevel=").append(upperLevel);
		sb.append(", url=").append(url);
		sb.append(", code=").append(code);
		sb.append(", sort=").append(sort);
		sb.append(", icon=").append(icon);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}

	
}