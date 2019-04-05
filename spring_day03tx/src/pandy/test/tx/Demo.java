package pandy.test.tx;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pandy.test.service.AccountService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class Demo {
	@Resource(name="accountService")
	private AccountService as;
	@Test
	public void fun1() {
		as.transfer(2, 1, 520d);
	}
}
