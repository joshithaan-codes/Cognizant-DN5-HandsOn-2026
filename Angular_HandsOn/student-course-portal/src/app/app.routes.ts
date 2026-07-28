import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { CourseList } from './components/course-list/course-list';
import { StudentProfile } from './components/student-profile/student-profile';
import { EnrollmentForm } from './pages/enrollment-form/enrollment-form';
import { StudentRegistration } from './pages/student-registration/student-registration';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'courses', component: CourseList },
  { path: 'profile', component: StudentProfile },

  { path: 'enroll', component: EnrollmentForm },
  { path: 'register', component: StudentRegistration },

  { path: '**', redirectTo: '' }
];