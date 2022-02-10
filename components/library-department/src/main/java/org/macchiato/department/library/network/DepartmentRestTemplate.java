package org.macchiato.department.library.network;

import lombok.RequiredArgsConstructor;
import org.macchiato.department.library.body.request.AddDepartmentRequest;
import org.macchiato.department.library.body.request.UpdateDepartmentRequest;
import org.macchiato.department.library.body.response.DepartmentResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class DepartmentRestTemplate implements DepartmentRestApi {
    private final RestTemplate restTemplate;

    @Override
    public UUID addDepartment(AddDepartmentRequest request) throws Exception {
        return restTemplate.postForObject("http://localhost:8080/department", request, UUID.class);
    }

    @Override
    public List<DepartmentResponse> getDepartments() throws Exception {
        ResponseEntity<List<DepartmentResponse>> exchange = restTemplate.exchange("http://localhost:8080/department/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<DepartmentResponse>>() {
        });
        return exchange.getBody();
//        DepartmentResponse[] response = restTemplate.getForObject("list", DepartmentResponse[].class);
//        assert response != null;
//        return Arrays.asList(response);
    }

    @Override
    public DepartmentResponse getDepartment(UUID departmentId) throws Exception {
        return restTemplate.getForObject("http://localhost:8080/department/" + departmentId.toString(), DepartmentResponse.class);
    }

    @Override
    public void updateDepartment(UUID departmentId, UpdateDepartmentRequest request) throws Exception {
        restTemplate.patchForObject("http://localhost:8080/department/" + departmentId.toString(), request, Object.class);
    }

    @Override
    public void deleteDepartment(UUID departmentId) throws Exception {
        restTemplate.delete("http://localhost:8080/department/" + departmentId.toString());
    }
}
