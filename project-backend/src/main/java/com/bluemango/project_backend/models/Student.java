package com.bluemango.project_backend.models; 

public class Student {

    private int id; 
    private String nome;
    private String email; 
    private String telefone; 
    private int curso; 
    private int turno;

    public Student(int id, String nome, String email, String telefone, int curso, int turno){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.curso = curso;
        this.turno = turno;
        System.out.println("Novo aluno cadastrado: "+ nome);
    }

    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getCurso() {
        return curso;
    }
    public void setCurso(int curso) {
        this.curso = curso;
    }
    public int getTurno() {
        return turno;
    }
    public void setTurno(int turno) {
        this.turno = turno;
    } 


    

    
}
