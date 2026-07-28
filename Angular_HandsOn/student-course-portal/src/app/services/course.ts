import { Injectable } from '@angular/core';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[] = [
  {
    id: 1,
    name: 'Angular Development',
    code: 'IT401',
    credits: 4,
    gradeStatus: 'passed'
  },
  {
    id: 2,
    name: 'Database Management',
    code: 'IT402',
    credits: 3,
    gradeStatus: 'passed'
  },
  {
    id: 3,
    name: 'Computer Networks',
    code: 'IT403',
    credits: 4,
    gradeStatus: 'pending'
  },
  {
    id: 4,
    name: 'Cloud Computing',
    code: 'IT404',
    credits: 3,
    gradeStatus: 'failed'
  },
  {
    id: 5,
    name: 'Artificial Intelligence',
    code: 'IT405',
    credits: 4,
    gradeStatus: 'pending'
  }
];

  getCourses(): Course[] {
    return this.courses;
  }

  getCourseById(id: number): Course | undefined {
    return this.courses.find(course => course.id === id);
  }

  addCourse(course: Course): void {
    this.courses.push(course);
  }
}