package com.br.monitoria.software.dto;


public class StudentSheetDTO {

    private String matricula;
    private String nome;
    private String pontoForms = "";
    private String atv1 = "";
    private String bad1 = "";
    private String atv2 = "";
    private String bad2 = "";
    private String atv3 = "";
    private String bad3 = "";
    private String atv4 = "";
    private String bad4 = "";
    private String atv5 = "";
    private String bad5 = "";
    private String perfil = "";
    private String quizz = "";
    private String learn = "";
    private String forms = "";
    private String conquistas = "";
    private String otimosExemplos = "";
    private String bonsRecursos = "";
    private String cumprirOTempo = "";
    private String baseTeorica = "";
    private String trabalhoEmEquipe = "";
    private String errorMessage;

    public StudentSheetDTO() {}

    public StudentSheetDTO(String errorMessage) {

        this.errorMessage = errorMessage;

    }
    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getPontoForms() { return pontoForms; }
    public void setPontoForms(String pontoForms) { this.pontoForms = pontoForms; }
    public String getAtv1() { return atv1; }
    public void setAtv1(String atv1) { this.atv1 = atv1; }
    public String getBad1() { return bad1; }
    public void setBad1(String bad1) { this.bad1 = bad1; }
    public String getAtv2() { return atv2; }
    public void setAtv2(String atv2) { this.atv2 = atv2; }
    public String getBad2() { return bad2; }
    public void setBad2(String bad2) { this.bad2 = bad2; }
    public String getAtv3() { return atv3; }
    public void setAtv3(String atv3) { this.atv3 = atv3; }
    public String getBad3() { return bad3; }
    public void setBad3(String bad3) { this.bad3 = bad3; }
    public String getAtv4() { return atv4; }
    public void setAtv4(String atv4) { this.atv4 = atv4; }
    public String getBad4() { return bad4; }
    public void setBad4(String bad4) { this.bad4 = bad4; }
    public String getAtv5() { return atv5; }
    public void setAtv5(String atv5) { this.atv5 = atv5; }
    public String getBad5() { return bad5; }
    public void setBad5(String bad5) { this.bad5 = bad5; }
    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }
    public String getQuizz() { return quizz; }
    public void setQuizz(String quizz) { this.quizz = quizz; }
    public String getLearn() { return learn; }
    public void setLearn(String learn) { this.learn = learn; }
    public String getForms() { return forms; }
    public void setForms(String forms) { this.forms = forms; }
    public String getConquistas() { return conquistas; }
    public void setConquistas(String conquistas) { this.conquistas = conquistas; }
    public String getOtimosExemplos() { return otimosExemplos; }
    public void setOtimosExemplos(String otimosExemplos) { this.otimosExemplos = otimosExemplos; }
    public String getBonsRecursos() { return bonsRecursos; }
    public void setBonsRecursos(String bonsRecursos) { this.bonsRecursos = bonsRecursos; }
    public String getCumprirOTempo() { return cumprirOTempo; }
    public void setCumprirOTempo(String cumprirOTempo) { this.cumprirOTempo = cumprirOTempo; }
    public String getBaseTeorica() { return baseTeorica; }
    public void setBaseTeorica(String baseTeorica) { this.baseTeorica = baseTeorica; }
    public String getTrabalhoEmEquipe() { return trabalhoEmEquipe; }
    public void setTrabalhoEmEquipe(String trabalhoEmEquipe) { this.trabalhoEmEquipe = trabalhoEmEquipe; }
}
