package com.cs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cs.model.User;
public class loginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("---------------进入拦截器");
               HttpSession session = request.getSession();  
               User user = (User) session.getAttribute("currentUser");  
               if(user!=null){  
                   //登陆成功的用户  
                   return true;  
               }else{  
                  //没有登陆，转向登陆界面  
                 response.sendRedirect("/UserController/forwordPage?page=login");
                 return false;  
               }  
	}

}
