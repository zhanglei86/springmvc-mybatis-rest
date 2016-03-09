
import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zl.model.TUsermx;
import com.zl.service.UserServiceI;

public class MyBatisTest {

	// @Autowired
	private UserServiceI userService;

	/**
	 * 这个before方法在所有的测试方法之前执行，并且只执行一次 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
	 * 比如在before方法里面初始化ApplicationContext和userService
	 */
	@Before
	public void before() {
		// 使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "spring.xml", "spring-jdbc.xml" });
		// 从Spring容器中根据bean的id取出我们要使用的userService对象
		userService = (UserServiceI) ac.getBean("userService");
		if (userService == null) {
			System.out.println("userService111是空的！！！");
		}else{
			System.out.println(userService+"++111");
		}
	}

	@Test
	public void testAddUser() {
		// ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		// UserServiceI userService = (UserServiceI) ac.getBean("userService");
		TUsermx user = new TUsermx();
		user.setUserName("wisdom"+UUID.randomUUID().toString().replaceAll("-", ""));
		user.setUserSex(1);
		user.setUserBirthday(new Date());
		user.setUserSalary(10000D);
		user.setUserOther("英腾仕途".getBytes());
		userService.addUser(user);
	}

}