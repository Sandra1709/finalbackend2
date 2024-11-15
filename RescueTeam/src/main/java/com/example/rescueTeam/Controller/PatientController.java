package com.example.rescueTeam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.messageSystem.model.SosMessage;
import com.example.rescueTeam.Services.PatientService;
import com.example.rescueTeam.model.Patient;
import com.example.rescueTeam.model.RescueRequest;
@RestController
@RequestMapping("/hospital")
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@PostMapping("/admit")
	public String admitPatient(@RequestBody RescueRequest admissionRequest) {

		// Extract SOS message and severity
		SosMessage sosMessage = admissionRequest.getSosMessage();
		String severity = admissionRequest.getSeverity();
		Patient patient = admissionRequest.getPatient();

		// Print the SOS message details (for debugging or auditing)
		System.out.println("Received SOS message: " + sosMessage);
		System.out.println("Severity level: " + severity);

		// Check hospital availability and admit the patient
		if (patientService.isHospitalAvailable()) {
			patientService.savePatient(patient);
			return "Patient " + patient.getPatientName() + " admitted successfully with severity: " + severity;
		} else {
			return "No hospitals available at this moment.";
		}
	}

	@GetMapping("/availability")
	public boolean checkHospitalAvailability() {
		return patientService.isHospitalAvailable();
	}

	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return patientService.getAllPatients();
	}
	
	
}



