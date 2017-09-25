package com.example.request.model;

import java.text.ParseException;

import com.example.utils.Page;
import com.example.utils.TimeUtils;

/**
 * Created by huc on 2017/8/25.
 */
public class AdminRequestBean extends Page{
	private Integer id;
    private String name;
    private String username;
    private String password;
    private String password1;
	private String s_time;
    private String e_time;
    private String menu;
    private Integer status;
    private Long addtime;
    private Long sTime;
    private Long eTime;
    private int is_display;
    
    
    
    public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}
    
    public Long getAddtime() {
		return addtime;
	}

	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIs_display() {
		return is_display;
	}

	public void setIs_display(int is_display) {
		this.is_display = is_display;
	}

	public Long getsTime() throws ParseException {
    	if(s_time!=null && !s_time.equals("")){
    		return TimeUtils.getFormatDate("yyyy-MM-dd hh:mm:ss", s_time +" 00:00:00");
    	}
    	return sTime;
	}

	public Long geteTime() throws ParseException {
		if(e_time!=null && !e_time.equals("")){
			return TimeUtils.getFormatDate("yyyy-MM-dd hh:mm:ss", e_time +" 23:59:59");
		}
		return eTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) throws ParseException {
        this.s_time = s_time;
    }

    public String getE_time() {
        return e_time;
    }

    public void setE_time(String e_time) {
        this.e_time = e_time;
    }

   
}
