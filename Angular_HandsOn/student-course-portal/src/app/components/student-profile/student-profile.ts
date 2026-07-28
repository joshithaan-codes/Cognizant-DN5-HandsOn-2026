import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EnrollmentService } from '../../services/enrollment';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css'
})
export class StudentProfile implements OnInit {

  student = {
    name: 'Joshitha A N',
    registerNumber: '23IT001',
    department: 'Information Technology',
    semester: 5,
    cgpa: 8.43
  };

  enrolledCourses: Course[] = [];

  constructor(
    private enrollmentService: EnrollmentService
  ) {}

  ngOnInit(): void {
    this.enrolledCourses =
      this.enrollmentService.getEnrolledCourses();
  }
}