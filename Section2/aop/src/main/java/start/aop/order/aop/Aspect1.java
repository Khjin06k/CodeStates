package start.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class Aspect1 {

    @Around("execution(* start.aop.order..*(..))") // 패키지 또는 해당 하위 패키지 중 하나에 정의된 메서드 실행 >> OrderService와 OrderRepository의 모든 메서드는 AOP 적용 대상
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable{ //Around 메서드인 logging은 어드바이스
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

}
