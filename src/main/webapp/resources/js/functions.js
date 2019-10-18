function modifingDisciplines() {
    var checkboxes = $('input[type=checkbox]:checked');
    if (checkboxes.length == 0) {
        alert("Пожалуйста, введите хотя бы одну дисциплину");
        return;
    }
    if (checkboxes.length > 1) {
        alert("Пожалуйста, выберите только одну дисциплину");
        return;
    }

    var idDisc = checkboxes[0].value;
    $("#idModifDisc").val(idDisc);
    $("#modifDiscForm").submit();
}

function deleteDiscipline() {
    var checkboxes = $('input[type=checkbox]:checked');
    if (checkboxes.length == 0) {
        alert("Пожалуйста, введите хотя бы одну дисциплину");
        return;
    }
    var ids = "";
    for (var i = 0; i < checkboxes.length; i++) {
        ids = ids + checkboxes[i].value + ",";
    }

    $("#idsDeleteDisc").val(ids); //disciplines.jsp
    $("#deleteDiscForm").submit(); //disciplines.jsp
}

function modifingStudent() {
    var checkboxes = $('input[type=checkbox]:checked');
    if (checkboxes.length == 0) {
        alert("Пожалуйста, выберите хотя бы одного студента");
        return;
    }
    if (checkboxes.length > 1) {
        alert("Пожалуйста, выберите только одного студента");
        return;
    }

    var idStud = checkboxes[0].value;
    $("#idModifStud").val(idStud);
    $("#modifStudForm").submit();
}

function deleteStudent() {
    var checkboxes = $('input[type=checkbox]:checked');
    if (checkboxes.length == 0) {
        alert("Пожалуйста, введите хотя бы одного студента");
        return;
    }
    var ids = "";
    for (var i = 0; i < checkboxes.length; i++) {
        ids = ids + checkboxes[i].value + ",";
    }

    $("#idsDeleteStud").val(ids); //students.jsp
    $("#deleteStudForm").submit(); //students.jsp
}

function progressStudent() {
    var checkboxes = $('input[type=checkbox]:checked');
    if (checkboxes.length == 0) {
        alert("Пожалуйста, выберите хотя бы одного студента");
        return;
    }
    if (checkboxes.length > 1) {
        alert("Пожалуйста, выберите только одного студента");
        return;
    }

    var idStud = checkboxes[0].value;
    $("#idProgStud").val(idStud);
    $("#ProgStudForm").submit();
}

function modifingSemestr() {
    var checkboxes = $('#multipleSelect:selected').val();
    // var checkboxes = $('#select-beast').selectize({
    //     create: true,
    //     sortField: 'text'
    // });


    var idSem = checkboxes[0].value;
    $("#idModifSem").val(idSem);
    $("#modifSemForm").submit();
}

function deleteSemestr() {
    var checkboxes = $('input[type=checkbox]:checked');
    if (checkboxes.length == 0) {
        alert("Пожалуйста, введите хотя бы один семестр");
        return;
    }
    var ids = "";
    for (var i = 0; i < checkboxes.length; i++) {
        ids = ids + checkboxes[i].value + ",";
    }

    $("#idsDeleteSem").val(ids); //semestrs.jsp
    $("#deleteSemForm").submit(); //semestrs.jsp
}

function choiseDisc(select) {

    var options = select && select.options;
    var opt;

    for (var i=0, iLen=options.length; i<iLen; i++) {
        opt = options[i];

        if (opt.selected) {
            result.push(opt.value || opt.text);
        }
    }


    var ids = "";

    for (var i = 0; i < options.length; i++) {
        ids = ids + options[i].value + ",";
    }

    $("#selectDiscipline").val(ids); //semestrs.jsp
    $("#createSemForm").submit(); //semestrs.jsp
}
function choiseSem() {
    var checkboxes = $('#multipleSelect:selected').val();

    var idSem = checkboxes[0].value;
    $("#idChoiseSem").val(idSem);
    $("#ChoiseSemForm").submit();

}
