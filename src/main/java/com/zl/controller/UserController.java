package com.zl.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.model.TUsermx;
import com.zl.service.UserServiceI;

import net.sf.json.JSONObject;

@Scope("prototype")
@Controller
@RequestMapping("V1")
public class UserController {

	/** 日志实例 */
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Resource(name = "userService")
	private UserServiceI userService;

	@RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String hello() {
		return "你好！hello";
	}

	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
	public @ResponseBody String say(@PathVariable(value = "msg") String msg) {
		return "{\"msg\":\"you say:'" + msg + "'\"}";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody Object addUser(TUsermx tUsermx) {
		logger.info("注册人员信息成功id=" + tUsermx.getUserId());
		JSONObject jsonObject = new JSONObject();
		TUsermx user = new TUsermx();
		user.setUserName("wisdom" + UUID.randomUUID().toString().replaceAll("-", ""));
		user.setUserSex(1);
		user.setUserBirthday(new Date());
		user.setUserSalary(10000D);
		user.setUserOther("英腾仕途".getBytes());
		userService.addUser(user);
		jsonObject.put("msg", user.getUserName() + "注册人员信息成功");
		return jsonObject;
	}

	@RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getUser(@PathVariable("id") int id) {
		logger.info("获取人员信息id=" + id);
		TUsermx tUsermx = new TUsermx();
		tUsermx = userService.getUserById(id + "");
		return tUsermx.getUserName();
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody Object getUserAll() {
		logger.info("获取全部人员信息=");
		List<TUsermx> tUsermxList = new ArrayList<TUsermx>();
		tUsermxList = userService.getAllUser();
		JSONObject jsonObject = new JSONObject();
		for (int i = 0; i < tUsermxList.size(); i = i + 1) {
			jsonObject.put(tUsermxList.get(i).getUserId(), tUsermxList.get(i).getUserName());
		}
		return jsonObject;
	}

	@RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	public @ResponseBody Object deleteUser(@PathVariable("id") int id) {
		logger.info("删除人员信息id=" + id);
		JSONObject jsonObject = new JSONObject();
		if (userService.delUser(id) == 1) {
			jsonObject.put("msg", id + "==删除人员信息成功");
		} else {
			jsonObject.put("msg", "删除失败！");
		}
		return jsonObject;
	}

}
