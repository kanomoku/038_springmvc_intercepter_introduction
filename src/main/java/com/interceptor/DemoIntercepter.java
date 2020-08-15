package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*一.自定义拦截器 zxs26621  徐应文
1.跟过滤器比较像的技术.
2.发送请求时被拦截器拦截,在控制器的前后添加额外功能.
	2.1 跟AOP 区分开.AOP 在特定方法前后扩充(对ServiceImpl)
	2.2 拦截器,请求的拦截.针对点是控制器方法.(对Controller)
3.SpringMVC 拦截器和Filter 的区别
	3.1 拦截器只能拦截器Controller
	3.2 Filter 可以拦截任何请求.
4.实现自定义拦截器的步骤:
	4.1 新建类实现HandlerInterceptor
	4.2 在springmvc.xml 配置拦截器需要拦截哪些控制器
		4.2.1 拦截所有控制器
		4.2.2 拦截特定的的url*/
public class DemoIntercepter implements HandlerInterceptor{

	//进入控制器之前执行，如果返回值是false则阻止进入控制器
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("preHandle");
		//拦截的控制器的方法
		System.out.println("arg2："+arg2);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return true;
	}

	//控制器执行完成，进入jsp之前执行
	//日志记录
	//敏感词语过滤
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");
		//拦截的控制器的方法
		System.out.println(arg2);
		System.out.println(arg3);
		String viewName = arg3.getViewName();
		Object object = arg3.getModel().get("key");
		System.out.println(viewName+object);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	//jsp执行完成后执行
	//记录执行过程中出现的异常，无论是否出现异常该方法都会被执行
	//可以把异常记录到日志中
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println(arg2);
		System.out.println(arg3);
		//根据arg3是否为null，判断是否出现异常
//		arg3.getMessage();
		System.out.println("afterCompletion");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
