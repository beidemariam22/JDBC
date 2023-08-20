package org.example.BuilderPattern;

import org.example.Models.Department;

public class DepartmentBuilder {
        private int departmentId;
        private String departmentName;

        public DepartmentBuilder departmentId(int departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public DepartmentBuilder departmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Department Build() {
            return new Department(departmentId, departmentName);
        }
    }


