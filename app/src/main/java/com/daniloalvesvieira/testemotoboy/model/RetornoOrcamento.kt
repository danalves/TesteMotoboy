package com.daniloalvesvieira.testemotoboy.model

data class RetornoOrcamento (var success: Boolean, var msg: String, var valor: Double,
                             var distancia: Double, var duracaoEstimadaMinutos: Double,
                             var horaTermino: String)