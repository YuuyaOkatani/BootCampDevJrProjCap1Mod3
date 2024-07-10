var alunos = [
    /*
    {
        id: 1,
        nome: "Pedro antônio",
        email: "pedro.antonio@abutua.com",
        telefone: "(99) 99999-9999",
        curso: 2,
        turno: 2
    }
        */
]

var cursos = [

]

var turnos = [
]




function save() {

    var turnosList = document.querySelectorAll('input[name="inputTurno"]')
    var turnoSet = null
    for(let turno of turnosList){
        if(turno.checked){
            turnoSet = turno.value
        }
    }



    var aluno = {
        id: alunos.length + 1,
        nome: document.getElementById("inputNome").value,
        email: document.getElementById("inputEmail").value,
        telefone: document.getElementById("inputPhone").value,
        curso: document.getElementById("inputCurso").value,
        turno: turnoSet
    }

    console.log(document.getElementById("inputCurso").value)

    

    console.log(aluno.curso)

    $.ajax({
        url: 'http://localhost:8080/students',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(aluno),
        success: student => {
            addNewRow(student)
            alunos.push(aluno);
            document.getElementById('formAlunos').reset()
        }
    })
  
}


function loadStudents() {

    var url = 'http://localhost:8080/students'

    $.getJSON(url, (students) => { //TODO arruma o array aluno
        alunos = students
        for (let student of alunos) {
            addNewRow(student)
        }
    })


 
}

function loadPeriods(){
    var UrlPeriod = 'http://localhost:8080/periods';
    $.ajax({
        url: UrlPeriod,
        type: 'GET',
        async: true,
        success: periods =>  {
            turnos = periods
            console.log(turnos)
        }
    })

}


function loadCourses(){

    var UrlCourses = 'http://localhost:8080/courses';

    $.ajax({
        url: UrlCourses,
        type: 'GET',
        async: true,
        success: courses =>  {
            cursos = courses
            console.log(courses)
            var cell = document.getElementById('inputCurso')

            for(let curso of cursos){
                cell.innerHTML += `<option value="${curso.id}">${curso.name}</option>`
            }
        }
    })

}

function addNewRow(aluno) {

    var table = document.getElementById("alunosTabela");
    var newRow = table.insertRow();
    var idnode = document.createTextNode(aluno.id);
    var cell = newRow.insertCell();
    cell.appendChild(idnode);

    cell = newRow.insertCell();
    cell.innerHTML = aluno.nome;

    cell = newRow.insertCell();
    cell.className = "d-none d-sm-table-cell"
    cell.innerHTML = aluno.email;

    cell = newRow.insertCell();
    cell.className = "d-none d-lg-table-cell"
    cell.innerHTML = aluno.telefone;

    cell = newRow.insertCell();
    cell.className = "d-none d-md-table-cell"
    for (let curso of cursos) {
        if (aluno.curso == curso.id) {
            cell.innerHTML = curso.name;
        }

    };

    cell = newRow.insertCell();
    cell.className = "d-none d-md-table-cell"
    for (let turno of turnos) {
        if (aluno.turno == turno.id) {
            cell.innerHTML = turno.name;
        }
    };

    











}

