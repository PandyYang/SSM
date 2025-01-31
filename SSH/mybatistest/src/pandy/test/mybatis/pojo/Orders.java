package pandy.test.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

public class Orders  implements Serializable{
    @Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + user_id + ", number=" + number + ", createtime=" + createtime
				+ ", note=" + note + ", user=" + user + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer user_id;

    private String number;

    private Date createtime;

    private String note;
    
    //附加对象  用户对象
    private User user;
    
    
    
    
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer userId) {
        this.user_id = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    
    
}