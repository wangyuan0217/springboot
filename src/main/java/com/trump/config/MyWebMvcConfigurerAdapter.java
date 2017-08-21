package com.trump.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    /**
     * 配置静态访问资源
     * 自定义资源映射addResourceHandlers
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 页面跳转addViewControllers
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //这样访问http://localhost:8080/toLogin就跳转到login.jsp页面了
//        registry.addViewController("moudle/loginAction").setViewName("login");
        registry.addViewController("/loginAction").setViewName("login");
        registry.addViewController("/indexAction").setViewName("index");
        registry.addViewController("/homeAction").setViewName("home");
        super.addViewControllers(registry);
    }

//    @Autowired
//    MyInterceptor mMyInterceptor;

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
//         excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/loginAction", "/test/login");
        super.addInterceptors(registry);
    }

}
