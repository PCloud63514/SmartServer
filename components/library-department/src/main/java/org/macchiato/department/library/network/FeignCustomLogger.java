package org.macchiato.department.library.network;


import feign.Logger;
import feign.Request;
import feign.Response;
import feign.Util;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
// https://github.com/goodGid/Feign_Demo_Project/blob/main/src/main/java/dev/be/goodgid/feign/logger/FeignCustomLogger.java
// https://goodgid.github.io/Analyzing-the-Feign-Client-and-Use/
// https://www.tabnine.com/code/java/methods/feign.Feign$Builder/errorDecoder
// https://engineering-skcc.github.io/msa/jhipster-feign/
@Slf4j
public class FeignCustomLogger extends Logger {

    @Override
    protected void log(String configKey, String format, Object... args) {

    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {

        super.logRequest(configKey, logLevel, request);
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime) throws IOException {
        if (response.body() != null) {
            byte[] bodyBytes = Util.toByteArray(response.body().asInputStream());
            String responseBody = new String(bodyBytes);
            log.info(responseBody);
            return response.toBuilder().body(bodyBytes).build();
        }
        return response;
    }
}
