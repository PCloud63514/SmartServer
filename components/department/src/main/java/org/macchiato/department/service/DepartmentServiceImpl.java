package org.macchiato.department.service;

import lombok.RequiredArgsConstructor;
import org.macchiato.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl {
    private final DepartmentRepository repository;
}
