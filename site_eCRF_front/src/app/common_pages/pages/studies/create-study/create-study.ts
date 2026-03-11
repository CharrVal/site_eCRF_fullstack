import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { RouterModule } from '@angular/router';
import { StudyService } from '../../../../services/studies/study-service';
import { PatientService } from '../../../../services/patients/patient-service';
import { Patient } from '../../../../interfaces/patients/patient';

@Component({
  selector: 'app-create-study',
  imports: [ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './create-study.html',
  styleUrl: './create-study.css',
})
export class CreateStudy implements OnInit {

  createStudyForm: FormGroup;
  patients: Patient[] = [];
  successMessage: string = '';
  errorMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private studyService: StudyService,
    private patientService: PatientService
  ) {

    this.createStudyForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      patients: []
    });
  }

  ngOnInit(): void {
    this.loadPatients();
  }

  loadPatients(): void {
    this.patientService.getAll().subscribe({
      next: patients => this.patients = patients,
      error: err => console.error('Erreur chargement patients', err)
    });
  }

  createStudy(): void {

    if (this.createStudyForm.invalid) {
      this.errorMessage = 'Formulaire invalide';
      return;
    }

    const studyRequest = this.createStudyForm.value;

    this.studyService.createStudy(studyRequest).subscribe({
      next: res => {
        this.successMessage = `Study "${res.name}" créée avec succès !`;
        this.errorMessage = '';
        this.createStudyForm.reset();
      },
      error: err => {
        console.error(err);
        this.errorMessage = "Erreur lors de la création de l'étude";
        this.successMessage = '';
      }
    });
  }
}
