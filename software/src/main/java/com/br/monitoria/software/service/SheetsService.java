package com.br.monitoria.software.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.monitoria.software.dto.Student;
import com.br.monitoria.software.exception.StudentNotFoundException;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

@Service
public class SheetsService {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static final String SPREADSHEET_ID = "1eho0FF0iU1HbillqQ91blyPVvVqH2cU3mogJffwntJQ"; 
    private static final String RANGE = "TabelaAlunosPontos ! A:AG"; 

    private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        InputStream in = SheetsService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public Student fetchStudentData(String studentId) throws IOException, GeneralSecurityException, StudentNotFoundException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values().get(SPREADSHEET_ID, RANGE).execute();
        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            throw new StudentNotFoundException("Estudante com essa matricula " + studentId + " não está cadastrado na turma.");
        }

        for (List<Object> row : values) {
            if (row.get(0).toString().equals(studentId)) {
                Student student = new Student();
                student.setMatricula(row.get(0).toString());
                student.setNome(row.get(1).toString());
                student.setPontoForms(Integer.parseInt(row.get(2).toString()));
                student.setAtv1(Integer.parseInt(row.get(3).toString()));
                student.setBad1(Integer.parseInt(row.get(4).toString()));
                student.setAtv2(Integer.parseInt(row.get(5).toString()));
                student.setBad2(Integer.parseInt(row.get(6).toString()));
                student.setAtv3(Integer.parseInt(row.get(7).toString()));
                student.setBad3(Integer.parseInt(row.get(8).toString()));
                student.setAtv4(Integer.parseInt(row.get(9).toString()));
                student.setBad4(Integer.parseInt(row.get(10).toString()));
                student.setAtv5(Integer.parseInt(row.get(11).toString()));
                student.setBad5(Integer.parseInt(row.get(12).toString()));
                student.setPerfil(row.get(13).toString());
                student.setQuizz(Integer.parseInt(row.get(14).toString()));
                student.setLearn(Integer.parseInt(row.get(15).toString()));
                student.setForms(Integer.parseInt(row.get(16).toString()));
                student.setConquistas(Integer.parseInt(row.get(17).toString()));
                student.setOtimosExemplos(Integer.parseInt(row.get(18).toString()));
                student.setBonsRecursos(Integer.parseInt(row.get(19).toString()));
                student.setCumprirOTempo(Integer.parseInt(row.get(20).toString()));
                student.setBaseTeorica(Integer.parseInt(row.get(21).toString()));
                student.setTrabalhoEmEquipe(Integer.parseInt(row.get(22).toString()));
                return student;
            }
        }
        throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
    }
}
