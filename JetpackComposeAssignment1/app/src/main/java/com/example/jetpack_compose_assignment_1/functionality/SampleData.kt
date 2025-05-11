package com.example.jetpack_compose_assignment_1.functionality

object CourseRepo{
    fun getSampleCourses(): List<Courses> = listOf(
        Courses(
            cId = 1,
            cCode = "IT110",
            cTitle = "Fundamentals of Networking",
            cCreditHr = 5.00,
            cDesc = "Fundamental concepts of internet, networks, and how connections are established.",
            cPreReqs = listOf("MATH101", "IET101")
    ),
        Courses(
            cId = 2,
            cCode = "PSY101",
            cTitle = "Fundamentals of Psychology",
            cCreditHr = 3.00,
            cDesc = "Psychology basics, Emotional Intelligence, Mental Well-being and Theories regarding the human mind.",
            cPreReqs = emptyList()
    ),
        Courses(
            cId = 3,
            cCode = "MATH101",
            cTitle = "Linear algebra",
            cCreditHr = 5.00,
            cDesc = "Fundamental concepts of Binary numbers, their logical operations, systems of Linear equations and vector spaces.",
            cPreReqs = listOf("MATH100")
    ),
        Courses(
            cId = 4,
            cCode = "IET101",
            cTitle = "Basics of Information Technology",
            cCreditHr = 3.00,
            cDesc = "Fundamental concepts of technology, machinery, AI, Big Data and Cybersecurity.",
            cPreReqs = listOf("SOC100")
    ),
        Courses(
            cId = 5,
            cCode = "SOC101",
            cTitle = "History of Technological advancements",
            cCreditHr = 3.00,
            cDesc = "Events from pre-industrialization, The First, Second and Third Industrial revolutions, and modern-era concepts regarding technological advancements.",
            cPreReqs = emptyList()
        )
    )
}