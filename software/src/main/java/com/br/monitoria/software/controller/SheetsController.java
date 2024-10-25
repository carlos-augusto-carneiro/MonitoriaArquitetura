package com.br.monitoria.software.controller;

import com.br.monitoria.software.service.SheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SheetsController {
    @Autowired
    private SheetsService sheetsService;

    @GetMapping("/sheets/student")
    public Map<String, Object> getStudentData(@RequestParam String studentId) {
        try {
            List<Object> studentData = sheetsService.getStudentData(studentId);
            if (studentData == null) {
                return null;
            }

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("matricula", studentData.get(0));
            result.put("atividade1", studentData.get(1));
            result.put("atividade2", studentData.get(2));
            result.put("atividade3", studentData.get(3));
            result.put("atividade4", studentData.get(4));
            result.put("atividade5", studentData.get(5));
            result.put("atividade6", studentData.get(6));
            result.put("atividade7", studentData.get(7));
            result.put("atividade8", studentData.get(8));
            result.put("atividade9", studentData.get(9));
            result.put("total", studentData.get(10));

            return result;
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }
}
