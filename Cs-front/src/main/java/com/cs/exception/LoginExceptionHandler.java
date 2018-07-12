package com.cs.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 登录失败的异常处理类
 * 
 * @author fan 创建时间：2018年7月12日
 */
@ControllerAdvice
public class LoginExceptionHandler {

	@ExceptionHandler(RuntimeException.class) // 要处理的异常的类型
	public String runtimeExceptionHandler(HttpServletRequest request, Exception e, Model model) {
		model.addAttribute("erroMsg", e.getMessage());// 将异常的信息放入erroMsg，然后从页面获取
		return "login";
	}
}
