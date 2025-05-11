package com.example.jetpack_compose_assignment_1.functionality

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack_compose_assignment_1.ui.theme.AcademiaCourseAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseCard(course: Courses, onExpandChange: (Boolean) -> Unit){
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onExpandChange(!course.isExpanded) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        )
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ){
            // Header containing essential info
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "${course.cId}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = course.cTitle,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                Text(
                    text = "${course.cCreditHr}CR",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            //Expanded details
            AnimatedVisibility(visible = course.isExpanded) {
                Column (
                    modifier = Modifier.padding(top = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )

                    Text(
                        text = course.cDesc,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    if(course.cPreReqs.isNotEmpty()) {
                        Text(
                            text = "Pre-requisites: ${course.cPreReqs.joinToString(", ")}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Collapse",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
            if(!course.isExpanded) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Expand",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseCardPreview() {
    AcademiaCourseAppTheme {
        CourseCard(
            course = Courses(
                cId = 1,
                cCode = "IT110",
                cTitle = "Fundamentals of Networking",
                cCreditHr = 5.00,
                cDesc = "Fundamental concepts of internet, networks, and how connections are established.",
                cPreReqs = listOf("MATH101", "IET101"),
                isExpanded = false
            ),
            onExpandChange = {}
        )
        CourseCard(
            course = Courses(
                cId = 2,
                cCode = "PSY101",
                cTitle = "Fundamentals of Psychology",
                cCreditHr = 3.00,
                cDesc = "Psychology basics, Emotional Intelligence, Mental Well-being and Theories regarding the human mind.",
                cPreReqs = emptyList(),
                isExpanded = true
            ),
            onExpandChange = {}
        )
        CourseCard(
                course = Courses(
                cId = 3,
                cCode = "MATH101",
                cTitle = "Linear algebra",
                cCreditHr = 5.00,
                cDesc = "Fundamental concepts of Binary numbers, their logical operations, systems of Linear equations and vector spaces.",
                cPreReqs = listOf("MATH100"),
                isExpanded = false
            ),
            onExpandChange = {}
        )

        CourseCard (
                course = Courses(
                cId = 4,
                cCode = "IET101",
                cTitle = "Basics of Information Technology",
                cCreditHr = 3.00,
                cDesc = "Fundamental concepts of technology, machinery, AI, Big Data and Cybersecurity.",
                cPreReqs = listOf("SOC100"),
                isExpanded = true
            ),
            onExpandChange = {}
        )
        CourseCard(
            course = Courses(
                cId = 5,
                cCode = "SOC101",
                cTitle = "History of Technological advancements",
                cCreditHr = 3.00,
                cDesc = "Events from pre-industrialization, The First, Second and Third Industrial revolutions, and modern-era concepts regarding technological advancements.",
                cPreReqs = emptyList(),
                isExpanded = false
            ),
            onExpandChange = {}
            )
        }
    }
