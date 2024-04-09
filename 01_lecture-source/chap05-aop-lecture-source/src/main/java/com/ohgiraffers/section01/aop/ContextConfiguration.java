package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers.section01.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {
    // proxy를 지정해주어야지 @Aspect 를 ApplicationContext 에 막는 형태로 적절히 감싸준다


}
