package org.macchiato.testsupport.sample;

import org.macchiato.testsupport.annotation.RunningTimeLogging;

public class SampleCode {

    @RunningTimeLogging
    public void run(int count) {
        System.out.println("동작 테스트 시도 중");
        int i = 0;
        while(i <= count) {
            i++;
        }
    }
}
