package pandy.test.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ASUS
 *序列化与反序列化  就是对象和字节形式进行转换
 *序列就是对象转化成字节形式
 *反序列化就是字节转换成二进制
 *以网络传输理解更加容易
 */
public class QueryVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	List<Integer> idsList;
	Integer[] ids;
	public List<Integer> getIdsList() {
		return idsList;
	}
	public void setIdsList(List<Integer> idsList) {
		this.idsList = idsList;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
