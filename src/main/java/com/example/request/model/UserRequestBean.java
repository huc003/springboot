package com.example.request.model;

import java.text.ParseException;

import com.example.utils.Page;
import com.example.utils.TimeUtils;

public class UserRequestBean extends Page{
	private Integer id;

    private String username;

    private String password;

    private String realname;

    private String cardId;

    private Integer sex;

    private Integer age;

    private String nickName;
    
    private Integer status;

    private Long addtime;
    
    private String s_time;
    private String e_time;
    
    private Long sTime;
    private Long eTime;
    
    private int is_display;
    
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getIs_display() {
		return is_display;
	}

	public void setIs_display(int is_display) {
		this.is_display = is_display;
	}

	public String getS_time() {
		return s_time;
	}

	public void setS_time(String s_time) {
		this.s_time = s_time;
	}

	public String getE_time() {
		return e_time;
	}

	public void setE_time(String e_time) {
		this.e_time = e_time;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Long getAddtime() {
		return addtime;
	}

	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}

	public void setsTime(Long sTime) {
		this.sTime = sTime;
	}

	public void seteTime(Long eTime) {
		this.eTime = eTime;
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
}
