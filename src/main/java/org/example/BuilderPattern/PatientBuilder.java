package org.example.BuilderPattern;
import org.example.Models.*;

public class PatientBuilder {

        private int patientId;
        private String patientName;
        private String patientDateOfBirth;
        private String patientGender;
        private String patientAddress;
        private String phoneNumber;
        private String patientEmail;
        private Nurse nurses;

        public PatientBuilder patientId(int patientId) {
            this.patientId = patientId;
            return this;
        }

        public PatientBuilder patientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public PatientBuilder patientDateOfBirth(String patientDateOfBirth) {
            this.patientDateOfBirth = patientDateOfBirth;
            return this;
        }

        public PatientBuilder patientGender(String patientGender) {
            this.patientGender = patientGender;
            return this;
        }

        public PatientBuilder patientAddress(String patientAddress) {
            this.patientAddress = patientAddress;
            return this;
        }

        public PatientBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PatientBuilder patientEmail(String patientEmail) {
            this.patientEmail = patientEmail;
            return this;
        }

        public PatientBuilder nurses(Nurse nurses) {
            this.nurses = nurses;
            return this;
        }

        public Patient Build() {
            return new Patient(patientId, patientName, patientDateOfBirth, patientGender, patientAddress,phoneNumber, patientEmail,nurses) ;
        }
    }




