var alunos = [
    {
        id: 1,
        nome: "Pedro antônio",
        email: "pedro.antonio@abutua.com",
        telefone: "(99) 99999-9999",
        curso: 2,
        turno: 2
    }
]

var cursos = [
    { id: 1, name: "Java" },
    { id: 2, name: "Angular" },
    { id: 3, name: "SQL" }
]

var turnos = [
    { id: 1, name: "Manhã" },
    { id: 2, name: "Tarde" },
    { id: 3, name: "Noite" }
]


loadProducts()

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
    console.log(aluno.turno)

    addNewRow(aluno)
    alunos.push(aluno)
    document.getElementById("formAlunos").reset()
    console.log("Saving...");
}

function loadProducts() {
    for (let aluno of alunos) {
        addNewRow(aluno)

    }
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

