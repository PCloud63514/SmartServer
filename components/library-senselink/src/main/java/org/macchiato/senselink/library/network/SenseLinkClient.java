package org.macchiato.senselink.library.network;

import org.macchiato.senselink.library.body.request.AddEmployeeRequest;
import org.macchiato.senselink.library.body.response.AddEmployeeResponse;
import org.macchiato.senselink.library.body.response.SenseLinkResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "senseLink", url = "localhost:8180/sense")
public interface SenseLinkClient {
    /**
     * 직원 추가
     */
    @PostMapping("/users")
    SenseLinkResponse<AddEmployeeResponse> addEmployee(@RequestBody AddEmployeeRequest request);


    /**
     * 직원 정보 변경
     */


    /**
     * 직원 정보 삭제
     */
}
