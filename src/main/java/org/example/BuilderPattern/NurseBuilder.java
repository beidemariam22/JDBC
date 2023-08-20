package org.example.BuilderPattern;

import org.example.Models.Nurse;

public class NurseBuilder {
        private int nurseId;
        private String nurseName;
        private String department;
        private String phoneNumber;
        private String email;

        public NurseBuilder nurseId(int nurseId) {
            this.nurseId = nurseId;
            return this;
        }

        public NurseBuilder nurseName(String nurseName) {
            this.nurseName = nurseName;
            return this;
        }

        public NurseBuilder department(String department) {
            this.department = department;
            return this;
        }

        public NurseBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public NurseBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Nurse Build() {
            return new Nurse(nurseId, nurseName, department,  phoneNumber,email);
        }
    }

