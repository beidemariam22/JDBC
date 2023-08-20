package org.example.Parsers;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.logging.Logger;

public class DomParser {
    private static final Logger LOGGER = Logger.getLogger(DomParser.class.getName());

    public static void main(String[] args) {

        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File("C:\\Users\\HP\\IdeaProjects\\JDBC\\src\\main\\resources\\Hospital.xml"));

            // Get the root element
            Element root = document.getDocumentElement();

            // Get the doctors
            NodeList doctorNodes = root.getElementsByTagName("doctor");
            for (int i = 0; i < doctorNodes.getLength(); i++) {
                Element doctorElement = (Element) doctorNodes.item(i);
                int doctorId = Integer.parseInt(doctorElement.getElementsByTagName("doctorId").item(0).getTextContent());
                String name = doctorElement.getElementsByTagName("name").item(0).getTextContent();
                String qualification = doctorElement.getElementsByTagName("qualification").item(0).getTextContent();
                String phoneNumber = doctorElement.getElementsByTagName("phoneNumber").item(0).getTextContent();
                String email = doctorElement.getElementsByTagName("email").item(0).getTextContent();

                // Print doctor information
                LOGGER.info("Doctors");
                LOGGER.info("Doctor ID: " + doctorId);
                LOGGER.info("Name: " + name);
                LOGGER.info("Qualification: " + qualification);
                LOGGER.info("Phone Number: " + phoneNumber);
                LOGGER.info("Email: " + email);

            }

            // Get the nurses
            NodeList nurseNodes = root.getElementsByTagName("nurse");
            for (int i = 0; i < nurseNodes.getLength(); i++) {
                Element nurseElement = (Element) nurseNodes.item(i);
                int nurseId = Integer.parseInt(nurseElement.getElementsByTagName("nurseId").item(0).getTextContent());
                String name = nurseElement.getElementsByTagName("name").item(0).getTextContent();
                String department = nurseElement.getElementsByTagName("department").item(0).getTextContent();
                String phoneNumber = nurseElement.getElementsByTagName("phoneNumber").item(0).getTextContent();
                String email = nurseElement.getElementsByTagName("email").item(0).getTextContent();

                // Print nurse information
                LOGGER.info("Nurses");
                LOGGER.info("Nurse ID: " + nurseId);
                LOGGER.info("Name: " + name);
                LOGGER.info("Department: " + department);
                LOGGER.info("Phone Number: " + phoneNumber);
                LOGGER.info("Email: " + email);

            }

            // Get the patients
            NodeList patientNodes = root.getElementsByTagName("patient");
            for (int i = 0; i < patientNodes.getLength(); i++) {
                Element patientElement = (Element) patientNodes.item(i);
                int patientId = Integer.parseInt(patientElement.getElementsByTagName("patientId").item(0).getTextContent());
                String name = patientElement.getElementsByTagName("name").item(0).getTextContent();
                String dateOfBirth = patientElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                String gender = patientElement.getElementsByTagName("gender").item(0).getTextContent();
                String address = patientElement.getElementsByTagName("address").item(0).getTextContent();
                String phoneNumber = patientElement.getElementsByTagName("phoneNumber").item(0).getTextContent();
                String email = patientElement.getElementsByTagName("email").item(0).getTextContent();
                int nurseId = Integer.parseInt(patientElement.getElementsByTagName("nurseId").item(0).getTextContent());

                // Print patient information
                LOGGER.info("Patients");
                LOGGER.info("Patient ID: " + patientId);
                LOGGER.info("Name: " + name);
                LOGGER.info("Date of Birth: " + dateOfBirth);
                LOGGER.info("Gender: " + gender);
                LOGGER.info("Phone Number: " + phoneNumber);
                LOGGER.info("Email: " + email);
                LOGGER.info("Nurse ID: " + nurseId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
