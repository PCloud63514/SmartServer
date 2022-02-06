package org.macchiato.department.repository;

import org.macchiato.department.domain.BaseDepartment;
import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentDatabaseEntity;
import org.macchiato.department.domain.DepartmentId;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DepartmentDatabaseRepository implements DepartmentRepository, FindBaseDepartment {
    private List<DepartmentDatabaseEntity> database = new ArrayList<>();

    @Override
    public Optional<Department> findBy(DepartmentId departmentId) {
        Optional<DepartmentDatabaseEntity> opt = findDepartmentById(departmentId);
        return opt.map(DepartmentDatabaseEntity::toDomainModel);
    }

    @Override
    public List<Department> findAll() {
        List<Department> response = new ArrayList<>();
        for (DepartmentDatabaseEntity e : database) {
            response.add(e.toDomainModel());
        }
        return response;
    }

    @Override
    public void save(Department department) {
        Optional<DepartmentDatabaseEntity> opt = findDepartmentById(department.getDepartmentInformation().getDepartmentId());
        if (opt.isEmpty()) {
            database.add(DepartmentDatabaseEntity.toDepartmentDatabaseEntity(department));
        } else {
            // TODO 향후 State가 더 나뉘면 별도의 메서드로 분리해줄 예정
            DepartmentDatabaseEntity departmentDatabaseEntity = opt.get();
            departmentDatabaseEntity.setName(department.departmentName());
            departmentDatabaseEntity.setDescription(department.description());
        }
    }

    @Override
    public void delete(DepartmentId departmentId) {
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getId().equals(departmentId.getDepartmentId())) {
                database.remove(i);
                break;
            }
        }
    }

    private Optional<DepartmentDatabaseEntity> findDepartmentById(DepartmentId departmentId) {
        return database.stream()
                .filter(d -> d.getId().equals(departmentId.getDepartmentId())).findFirst();
    }

    @Override
    public Optional<BaseDepartment> findBaseDepartmentBy(DepartmentId departmentId) {
        Optional<DepartmentDatabaseEntity> opt = findDepartmentById(departmentId);
        if (opt.isPresent()) {
            DepartmentDatabaseEntity departmentDatabaseEntity = opt.get();
            if (departmentDatabaseEntity.getState() == DepartmentDatabaseEntity.DepartmentState.Base) {
                return Optional.of((BaseDepartment) departmentDatabaseEntity.toDomainModel());
            }
        }
        return Optional.empty();
    }
}
