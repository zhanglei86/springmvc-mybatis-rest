
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdy.model.TUsermx;
import com.hdy.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class MyBatisTestBySpringTestFramework {

    //注入userService
    @Autowired
    private UserServiceI userService;
    
    
    @Test
    public void testGetUserById(){
        String userId = "9a9c061ca39d44f69aff78f6d29d571a";
        TUsermx user = userService.getUserById(userId);
        System.out.println(user.getUserName());
    }
}