package com.example.jetpack_compose_assignment_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_assignment_1.functionality.CourseCard
import com.example.jetpack_compose_assignment_1.functionality.CourseViewModel
import com.example.jetpack_compose_assignment_1.ui.theme.AcademiaCourseAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AcademiaCourseAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseListScreen()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CourseListScreen(viewModel: CourseViewModel = CourseViewModel()) {

    val courses by viewModel.courses.collectAsState()

   LazyColumn (
       modifier = Modifier.padding(16.dp),
       verticalArrangement = Arrangement.spacedBy(8.dp)
   ) {

       items(courses){ course ->
           CourseCard(
               course = course,
               onExpandChange = {
                   viewModel.toggleCourseExpansion(course.cId)
               }
           )
         }
    }
}
