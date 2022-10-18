package start.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class Aspect2 {

    @Pointcut("execution(* start.aop.order..*(..))") //포인트컷 표현식 사용, 메서드 이름/파라미터를 합쳐 포인트컷 시그니처라 함
    private void allOrder(){} //private 이므로 내부에서만 사용

    @Around("allOrder()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable { //public은 다른 애스팩트에서 참고
        log.info("log -> {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }
}
