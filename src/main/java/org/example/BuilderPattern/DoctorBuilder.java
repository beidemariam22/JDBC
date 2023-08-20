package org.example.BuilderPattern;
import org.example.Models.*;

import java.util.List;

public class DoctorBuilder {
        private int doctorId;
        private String doctorName;
        private String doctorQualification;
        private String phoneNumber;
        private String email;
        private List<Patient> patientsList;

        public DoctorBuilder doctorId(int doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public DoctorBuilder doctorName(String doctorName) {
            this.doctorName = doctorName;
            return this;
        }

        public DoctorBuilder doctorQualification(String doctorQualification) {
            this.doctorQualification = doctorQualification;
            return this;
        }

        public DoctorBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public DoctorBuilder email(String email) {
            this.email = email;
            return this;
        }

        public DoctorBuilder patientsList(List<Patient> patientsList) {
            this.patientsList = patientsList;
            return this;
        }

        public Doctor Build() {
            return new Doctor(doctorId,doctorName,doctorQualification,phoneNumber,email);
        }
    }

