package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Map;

@Component
@Aspect
public class LoggingAspect {

    /*필기.
    *  @Pointcut : 여러 조인 포인트(실제 타겟)를 매치하기 위해 지정한 표현식
    *  execution("[수식어] 리턴타입 [클래스 이름].메소드(파라미터)")
    *  수식어로는 접근 제한자를 사용할 수 있다(public, protected, default, private)
    *  *Service 는 ~Service 인 모든 클래스를 지칭한다
    *  *Service.*(..) : 매개변수가 0 개 이상인 모든 메소드 지칭
    *  *Service.*(*) : 매개변수가 1개인 모든 메소드 지칭
    *  *Service.*(*,..) : 매개변수가 1개 이상인 모든 메소드 지칭 */

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointCut(){
        // 항상 void 이어야 한다
        // 메소드 명이 pointcut 의 이름이 된다
    }

    /*필기.
    *  advice 의 종류
    *  @Before
    *  @After
    *  @AfterReturning
    *  @AfterThrowing
    *  @Around
    *  이렇게 총 5가지 존재한다*/

    /*필기.
    *  JoinPoint : 포인트 컷으로 패치한 실행 지점(타겟)
    *  이렇게 매치된 조인 포인트에서 해야할 일을 지정하는 것이 Advice 라고 한다.
    *  매개변수로 전달한 JoinPoint 는 현재 JoinPoint의 매소드명, 인수값 등의
    *  정보들을 가져올 수 있다*/
    @Before("LoggingAspect.logPointCut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("before joinPoint.getSignature() : " + joinPoint.getSignature());
        // getSignature 는 해당 joinpoint 의 메소드 시그니쳐를 보여준다
        if(joinPoint.getArgs().length>0){
            System.out.println("before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }

    }
    /*필기. After Advice 는 예외 발생 여부와 관계없이 공통내용을 수행한다*/

    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("after joinPoint.getSignature() : " + joinPoint.getSignature());

    }

    /*필기.
    *  returning 속성은 리턴값으로 받아 올 오브젝트의 매개변수 이름과 동일해야한다
    *  또한 JoinPoint 는 반드시 첫 번째 매개변수로 선언을 해야 한다*/

    @AfterReturning(pointcut = "logPointCut()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("AfterReturning result : "+result);
        /* result 라는 공간에 반환값이 들어 있다. 따라서 결과 값을 변경할 수 도 있다*/
        if(result !=null && result instanceof Map){
            ((Map<Long,MemberDTO>) result).put(50L, new MemberDTO(50L,"변경해보기"));
        }
    }

    /*필기.
    *  대상 메소드(joinpoint) 를 실행하는 도중 예외가 발생하는 경우 공통의 기능 수행
    *  throwing 속성은 매개변수의 이름과 동일해야하는 특징이 동일하게 존재한다*/
    @AfterThrowing(pointcut = "logPointCut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("After Throwing exception : "+exception);
    }

    /*필기.
    *  Around Advice
    *  Around 는 JoinPoint 의 앞과 뒤를 모두 장악한다
    *  원본 JoinPoint(타겟 메소드) 를 언제 실행할 지, 실행하지 않을지 , 계속 실행할지 결정한다
    *  Around Advice 는 ProceedingJoinPoint 를 매개변수로 받는다*/

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 타겟 실행전 공간
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("around before : " + joinPoint.getSignature().getName());

        // 타겟이 실행된 것
        // 시살상 타겟이 실행되는 장소는 여기 인것이다
        Object result = joinPoint.proceed();
        if(result!=null && result instanceof Map){
            ((Map<Long,MemberDTO>)result).put(30L,new MemberDTO(30L,"나다"));
        }


        // 타겟 실행 후 공간
        System.out.println("around after : "+joinPoint.getSignature().getName());
        stopWatch.stop();
        System.out.println("메소드 실행에 소요된 시간 : "+ stopWatch.getTotalTimeNanos() +"(ns)");

        /*필기. 원본 조인포인트를 호출한 쪽 or 다른 어드바이스가 다시 실행할수 있도록 반환을 해준다*/
        return result;
    }

}
