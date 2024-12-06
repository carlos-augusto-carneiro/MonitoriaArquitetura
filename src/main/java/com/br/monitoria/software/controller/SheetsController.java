package com.br.monitoria.software.controller;



import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.monitoria.software.dto.Student;
import com.br.monitoria.software.exception.StudentNotFoundException;
import com.br.monitoria.software.service.SheetsService;

@Controller
public class SheetsController {
    @Autowired
    private SheetsService sheetsService;

    @GetMapping("/sheets/student")
    public String getStudentData(@RequestParam("studentId") String studentId, Model model) {
        try {
            // Fetch data from the spreadsheet using the studentId
            Student student = sheetsService.fetchStudentData(studentId);
            
            // Add the student data to the model
            model.addAttribute("student", student);
            
            // Return the view name
            return "student";
        } catch (IOException | GeneralSecurityException e) {
            model.addAttribute("error", "Erro ao buscar dados do estudante: " + e.getMessage());
            return "error";
        } catch (StudentNotFoundException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

}
