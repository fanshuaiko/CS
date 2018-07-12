package com.cs.web;

import com.cs.model.ResetPassword;
import com.cs.model.User;
import com.cs.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

/**
 * 用户管理Controller
 * @author fanshui
 * @date 18-7-8 下午5:01
 */
@Controller
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private IUserService userServiceImpl;
/**
 * 用户登录
 * @param user 封装用户输入的用户名和密码
 * @param model
 * @param session
 * @return
 */
    @PostMapping("/login")
    public String login(User user,Model model,HttpSession session) {
    	User currentUser = userServiceImpl.login(user);
    	session.setAttribute("currentUser", currentUser);
    	System.out.println("////////"+currentUser);
    		return "redirect:/IndexController/index";
    	
    }
    /**
     * 用户注册
     * @param user 封装用户输入的信息
     * @param model
     * @return
     */
    @PostMapping("/register")
    public String register(User user,Model model) {
    	User u = userServiceImpl.save(user);
    	System.out.println("==========" + u);
    	return "login";
    }
    /**
     * 更新用户信息
     * @param user 封装用户输入的信息
     * @param session
     * @return
     */
    @PostMapping("/update")
    public String update(User user,HttpSession session) {
    	User currentUser = userServiceImpl.save(user);
    	session.setAttribute("currentUser", currentUser);//将更新后的用户信息放入Session
    	return "redirect:/IndexController/index";
    }
 /**
  * 跳转到用户信息修改页面
  * @param model
  * @return
  */
    @GetMapping("/findById")
    public String findById(Model model) {

    	return "editUserMessage";
    }
    /**
     * 根据输入正确的电话号码即可重置密码
     * 安全性薄弱
     * @param r
     * @param model
     * @return
     */
    @GetMapping("/resetPassword")
    public String resetPassword(ResetPassword r,Model model) {
    	User user = userServiceImpl.resetPassword(r.getUserName(), r.getUserTel());
    	if(user != null) {
    		return "login";
    	}else {
    		return "resetPassword";
    	}
    }
    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/quit")
    public String quit(HttpSession session) {
    	session.removeAttribute("currentUser");
    	return "redirect:/IndexController/index";
    }
    /**
     * 跳转页面
     * @param page 要跳转的页面
     * @return
     */
    @GetMapping("/forwordPage")
	public String forwordPage(String page) {
		return page;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    @GetMapping("/queryAll")
//    public String queryAll(){
//        List<User> list = userServiceImpl.findAll();
//       for(User user : list){
//           System.out.println(user);
//       }
//        return "success";
//    }

}
