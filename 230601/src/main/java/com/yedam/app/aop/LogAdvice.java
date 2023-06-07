package com.yedam.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // pointcut advice 세부파일
@Component
public class LogAdvice {
	
	//포인트컷 : 조인포인트 ( 비즈니스 로직과 관련된 메소드 ) 중에서 Abvice (공통코드) 가 적용될 메소드
	@Pointcut("within(com.yedam.app.emp.mapper.*)")// 해당 경로 내 메서드 전부 적용
	public void allPointCut() {
		
	}
	
	//Weaving : 포인트컷 + Advice + 동작시점 이 3가지가 결합되어야한다 
	@Around("allPointCut()")//비즈니스 메소드 중간에두고 앞뒤로 실행 / 매개변수로 ProceedingJoinpoint 가져옴
	public Object logger(ProceedingJoinPoint joinpoint) throws Throwable {
		//Aop 가 적용되는 메서드의 이름
		String signatureStr = joinpoint.getSignature().toString();
		System.out.println("시작 :" + signatureStr);
		//공통기능
		System.out.println("핵심 기능 전 실행 - 공통기능 : " + System.currentTimeMillis());
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}finally{
			//공통기능
			System.out.println("핵심 기능 후 실행 - 공통기능 : " + System.currentTimeMillis());
		}
	}
	
}
