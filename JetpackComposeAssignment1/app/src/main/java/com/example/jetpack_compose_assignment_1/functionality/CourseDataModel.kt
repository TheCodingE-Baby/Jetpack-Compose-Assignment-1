package com.example.jetpack_compose_assignment_1.functionality

data class Courses (
    val cId: Int,
    val cCode: String,
    val cTitle: String,
    val cCreditHr: Double,
    val cDesc: String,
    val cPreReqs: List<String>,
    val isExpanded: Boolean = false
)
