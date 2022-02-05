package org.macchiato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.macchiato.testsupport.annotation.RunningTimeLogging;
import org.macchiato.testsupport.aop.aspect.RunTimeLoggerAspect;
import org.macchiato.testsupport.sample.SampleCode;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.DefaultAopProxyFactory;

public class AopTest {
    RunTimeLoggerAspect aspect = new RunTimeLoggerAspect();
    SampleCode sampleCode;
    @BeforeEach
    public void setUp() {
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(new SampleCode());
        aspectJProxyFactory.addAspect(aspect);

        DefaultAopProxyFactory proxy = new DefaultAopProxyFactory();
        AopProxy aopProxy = proxy.createAopProxy(aspectJProxyFactory);

        sampleCode = (SampleCode) aopProxy.getProxy();
    }

    @Test
    void aopTest() {
        sampleCode.run(100000);
    }
}
