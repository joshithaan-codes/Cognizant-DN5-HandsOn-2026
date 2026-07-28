import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';

@Component({
  selector: 'app-student-registration',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './student-registration.html',
  styleUrl: './student-registration.css'
})
export class StudentRegistration {

  registrationForm: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) {

    this.registrationForm = this.fb.group({

      fullName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],

      email: [
        '',
        [
          Validators.required,
          Validators.email
        ]
      ],

      password: [
        '',
        [
          Validators.required,
          Validators.minLength(6)
        ]
      ],

      department: ['', Validators.required]

    });
  }

  onSubmit(): void {

    if (this.registrationForm.valid) {

      console.log(
        'Registration:',
        this.registrationForm.value
      );

      this.submitted = true;
    }
  }
}