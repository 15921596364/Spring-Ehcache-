package com.controller;

import com.model.User;
import com.service.UserService;
import com.utils.RespMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author y15079
 * @create 2017-10-24 10:31
 * @desc
 **/
@Controller
public class UserController {



	@Resource
	private UserService userService;

    /**
     * 初始化首页
     * @param model
     * @return
     */
	@RequestMapping("")
	public String testUser(Model model){
		User user=userService.findUser("3y2d");
		model.addAttribute("user",user);
		return "index";
	}

    /**
     * 获取用户列表
     * @return
     */
	@ResponseBody
	@RequestMapping(value = "/list")
	public RespMsg list(){
		RespMsg respMsg = new RespMsg();
		List<User> users = userService.getUsers();
		respMsg.setResult(true,"1","获取成功",users);
		return respMsg;
	}

    /**
     * 获取用户统计数量
     * @return
     */
	@ResponseBody
	@RequestMapping(value = "/count",method = RequestMethod.POST)
	public Object count(){
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		int count=userService.count();
		map.put("hello",count);
		return map;
	}

    /**
     * 添加用户
     * @return
     */
	@ResponseBody
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public Object insert(){
		Integer id = new Random().nextInt(100);
		HashMap<String,Boolean> map=new HashMap<String,Boolean>();
		try {
			User user=new User(id.toString(),"hello"+id.toString(),"14");
			userService.insert(user);
			map.put("flag",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
