(function(global, factory) {

    if (typeof module === "object" && typeof module.exports === "object") {
        module.exports = factory();
    } else {
        factory();
    }
}(typeof window !== "undefined" ? window : this, function() {
    var i18n = {
        "sEmptyTable" : "Nenhum registro encontrado",
        "sInfo" : "Mostrando de _START_ até _END_ de _TOTAL_ registros",
        "sInfoEmpty" : "Mostrando 0 até 0 de 0 registros",
        "sInfoFiltered" : "(Filtrados de _MAX_ registros)",
        "sInfoPostFix" : "",
        "sInfoThousands" : ".",
        "sLengthMenu" : "_MENU_ resultados por página",
        "sLoadingRecords" : "Carregando...",
        "sProcessing" : "Processando...",
        "sZeroRecords" : "Nenhum registro encontrado",
        "sSearch" : "Pesquisar",
        "oPaginate" : {
            "sNext" : "Próximo",
            "sPrevious" : "Anterior",
            "sFirst" : "Primeiro",
            "sLast" : "Último"
        },
        "oAria" : {
            "sSortAscending" : ": Ordenar colunas de forma ascendente",
            "sSortDescending" : ": Ordenar colunas de forma descendente"
        }
    };

    if (typeof define === "function" && define.amd) {
        define([], function() {
            return i18n;
        });
    }

    return i18n;
}));
