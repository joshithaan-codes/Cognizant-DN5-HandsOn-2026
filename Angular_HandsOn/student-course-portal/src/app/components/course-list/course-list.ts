import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../course-card/course-card';
import { HighlightDirective } from '../../directives/highlight';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    CommonModule,
    CourseCard,
    HighlightDirective
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = true;

  selectedCourseId: number | null = null;

  courses: Course[] = [];

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {

    // Get course data from the shared CourseService
    this.courses = this.courseService.getCourses();

    // Simulate loading
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  onCourseSelected(courseId: number): void {
    this.selectedCourseId = courseId;
  }

  // Handles the event emitted by CourseCard
  onEnroll(courseId: number): void {
    console.log('Enrollment requested for course:', courseId);
    this.selectedCourseId = courseId;
  }

  // Helps Angular efficiently track courses in *ngFor
  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }
}