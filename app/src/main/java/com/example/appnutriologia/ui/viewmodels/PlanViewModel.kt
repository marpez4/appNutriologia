package com.example.appnutriologia.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.appnutriologia.model.PlanCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlanViewModel: ViewModel(){

    private val _cards = MutableStateFlow<List<PlanCard>>(emptyList())
    val cards: StateFlow<List<PlanCard>> = _cards

    init {
        loadPlanCards()
    }

    private fun loadPlanCards(){
        _cards.value = listOf(
            PlanCard(
                title = "Menú de Diciembre",
                content = """
            • Desayuno: Avena con manzana y nueces.
            • Almuerzo: Ensalada de quinoa con pollo y verduras asadas.
            • Cena: Sopa de lentejas y tostadas integrales.
            • Snack: Yogur natural con fresas.
            • Actividad: 30 minutos de ejercicio diario.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Noviembre",
                content = """
            • Desayuno: Smoothie verde (espinaca, plátano y leche de almendra).
            • Almuerzo: Salmón al horno con arroz integral y brócoli.
            • Cena: Ensalada de espinacas con huevo cocido.
            • Snack: Zanahorias baby con hummus.
            • Tip: Consume frutas y verduras en cada comida.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Octubre",
                content = """
            • Desayuno: Tortilla de espinacas con aguacate.
            • Almuerzo: Pechuga de pollo a la parrilla con puré de camote.
            • Cena: Crema de calabaza con pan integral.
            • Snack: Nueces y almendras (un puñado).
            • Tip: Bebe al menos 2 litros de agua al día.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Septiembre",
                content = """
            • Desayuno: Pan integral con queso fresco y jitomate.
            • Almuerzo: Filete de pescado con ensalada fresca.
            • Cena: Caldo de pollo con verduras.
            • Snack: Manzana con crema de cacahuate.
            • Tip: Duerme entre 7 y 8 horas cada noche.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Agosto",
                content = """
            • Desayuno: Yogur natural con granola y frutos rojos.
            • Almuerzo: Tacos de lechuga con carne molida y guacamole.
            • Cena: Omelette de champiñones y espinacas.
            • Snack: Palomitas caseras sin mantequilla.
            • Actividad: Practica yoga o pilates.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Julio",
                content = """
            • Desayuno: Smoothie de mango y piña con leche de coco.
            • Almuerzo: Ensalada César con pollo asado.
            • Cena: Verduras al vapor con tofu.
            • Snack: Uvas congeladas.
            • Tip: Evita alimentos procesados.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Junio",
                content = """
            • Desayuno: Pan integral con aguacate y huevo cocido.
            • Almuerzo: Albóndigas de pollo con arroz y ensalada.
            • Cena: Sopa minestrone.
            • Snack: Batido de proteína con plátano.
            • Tip: Planifica tus comidas con anticipación.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Mayo",
                content = """
            • Desayuno: Tostadas integrales con ricota y miel.
            • Almuerzo: Pechuga de pavo con puré de zanahoria.
            • Cena: Ensalada caprese.
            • Snack: Barrita de avena casera.
            • Tip: Mantén un horario regular de comidas.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Abril",
                content = """
            • Desayuno: Licuado de plátano, avena y leche.
            • Almuerzo: Fajitas de pollo con pimientos y tortillas de maíz.
            • Cena: Sopa de tomate con crutones integrales.
            • Snack: Kiwi con semillas de chía.
            • Actividad: Sal a caminar después de comer.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Marzo",
                content = """
            • Desayuno: Ensalada de frutas con yogur.
            • Almuerzo: Pasta integral con verduras y salsa de tomate natural.
            • Cena: Omelette de claras con espinacas.
            • Snack: Arándanos secos (sin azúcar).
            • Tip: Reduce tu consumo de sal.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Febrero",
                content = """
            • Desayuno: Tazón de avena con cacao y almendras.
            • Almuerzo: Chuleta de cerdo con puré de papa.
            • Cena: Wrap de atún con lechuga y tomate.
            • Snack: Pepino con limón y chile en polvo.
            • Tip: Limita el consumo de refrescos.
        """.trimIndent()
            ),
            PlanCard(
                title = "Menú de Enero",
                content = """
            • Desayuno: Huevos revueltos con espinacas y pan integral.
            • Almuerzo: Pollo al limón con arroz salvaje y verduras.
            • Cena: Caldo de res con garbanzos y zanahorias.
            • Snack: Plátano con mantequilla de almendra.
            • Actividad: Empieza un diario de hábitos saludables.
        """.trimIndent()
            )
        )

    }
}