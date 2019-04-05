package pandy.test.c_service;

public class UserServiceImpl implements UserService {

	public void save() {
		// TODO Auto-generated method stub
		System.out.println("打开事务");
		System.out.println("保存用户");
		System.out.println("提交事务");
	}

	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("删除用户");
	}

	public void update() {
		// TODO Auto-generated method stub
		System.out.println("更新用户");
	}

	public void find() {
		// TODO Auto-generated method stub
		System.out.println("查找用户");
	}
	
}
