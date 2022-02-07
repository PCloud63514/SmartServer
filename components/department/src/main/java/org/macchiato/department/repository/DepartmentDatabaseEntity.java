package org.macchiato.department.repository;


import lombok.*;
import org.macchiato.department.domain.BaseDepartment;
import org.macchiato.department.domain.Department;
import org.macchiato.department.domain.DepartmentId;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class DepartmentDatabaseEntity {
    public enum DepartmentState {
        Base
    }

    UUID id;
    String name;
    String description;
    DepartmentState state;

     public Department toDomainModel() {
        switch (state) {
            case Base:
            default: return this.toBaseDepartment();
        }
    }

    @Builder(access = AccessLevel.PRIVATE)
    public DepartmentDatabaseEntity(UUID id, String name, String description, DepartmentState state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    private BaseDepartment toBaseDepartment() {
        return new BaseDepartment(new DepartmentId(id), name, description);
    }

    public static DepartmentDatabaseEntity toDepartmentDatabaseEntity(Department department) {
        DepartmentDatabaseEntityBuilder builder = DepartmentDatabaseEntity.builder();
        builder.id(department.departmentId());
        builder.name(department.departmentName());
        builder.description(department.description());

        // TODO instanceOf 사용해서 builder 분기 주던지 해야할듯 씁 instanceof 싫다.
        if (department instanceof BaseDepartment) {
            builder.state(DepartmentState.Base);
        }
        return builder.build();
    }
}
