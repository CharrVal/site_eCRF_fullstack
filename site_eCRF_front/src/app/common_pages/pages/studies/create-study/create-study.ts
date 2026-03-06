import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { RouterModule } from '@angular/router';
import { Study } from '../../../../interfaces/studies/study';
import { HttpClient } from '@angular/common/http';
import { StudyService } from '../../../../services/studies/study-service';

@Component({
  selector: 'app-create-study',
  imports: [ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './create-study.html',
  styleUrl: './create-study.css',
})
export class CreateStudy {

  createStudyForm: FormGroup;
  successMessage : string = '';
  errorMessage : string = '';

  constructor (
    private fb:FormBuilder,
    private studyService: StudyService,
    private cdr: ChangeDetectorRef) {
    this.createStudyForm = this.fb.group({
      name: ['',Validators.required],
      description: ['', Validators.required],
      patients: []
    });
  }

  createStudy() {
    return "not implemented"
  }
}
