package com.br.monitoria.software.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.monitoria.software.dto.StudentSheetDTO;
import com.br.monitoria.software.exception.StudentNotFoundException;
import com.br.monitoria.software.service.SheetsService;

@RestController
public class SheetsController {
    @Autowired
    private SheetsService sheetsService;

    @GetMapping("/sheets/student")
    public ResponseEntity<StudentSheetDTO> getStudentSheet(@RequestParam("studentId") String studentId) {
        try {
            List<Object> studentData = sheetsService.getStudentData(studentId);

            if (studentData.size() < 23) {
                return ResponseEntity.status(400).body(new StudentSheetDTO("Error: Insufficient data for student ID " + studentId));
            }

            StudentSheetDTO result = new StudentSheetDTO();
            result.setMatricula((String) studentData.get(0));
            result.setNome((String) studentData.get(1));
            result.setPontoForms((String) studentData.get(2));
            result.setAtv1((String) studentData.get(3));
            result.setBad1((String) studentData.get(4));
            result.setAtv2((String) studentData.get(5));
            result.setBad2((String) studentData.get(6));
            result.setAtv3((String) studentData.get(7));
            result.setBad3((String) studentData.get(8));
            result.setAtv4((String) studentData.get(9));
            result.setBad4((String) studentData.get(10));
            result.setAtv5((String) studentData.get(11));
            result.setBad5((String) studentData.get(12));
            result.setPerfil((String) studentData.get(13));
            result.setQuizz((String) studentData.get(14));
            result.setLearn((String) studentData.get(15));
            result.setForms((String) studentData.get(16));
            result.setConquistas((String) studentData.get(17));
            result.setOtimosExemplos((String) studentData.get(18));
            result.setBonsRecursos((String) studentData.get(19));
            result.setCumprirOTempo((String) studentData.get(20));
            result.setBaseTeorica((String) studentData.get(21));
            result.setTrabalhoEmEquipe((String) studentData.get(22));

            return ResponseEntity.ok(result);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(404).body(new StudentSheetDTO("Error: " + e.getMessage()));
        } catch (IOException | GeneralSecurityException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
