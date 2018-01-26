package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class TheWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(TheWatcher.class);

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object processOrderEvent(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object process = null;
        try {
            LOGGER.info("Begin of processOrder execution");
            process = proceedingJoinPoint.proceed();
            LOGGER.info("End of processOrder");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
        }
        return process;
    }
}
