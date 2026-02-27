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

  constructor (private fb:FormBuilder,
    private studyService: StudyService,
    private http: HttpClient,
    private cdr: ChangeDetectorRef) {
    this.createStudyForm = this.fb.group({
      name: ['',Validators.required],
      description: ['', Validators.required],
      patients: []
    });
  }

  createStudy() {
    if(this.createStudyForm.invalid){
      return console.log("formulaire non valide");
    }

    const formValue = this.createStudyForm.value;

    const study : Study = {
      id: 1,
      name : formValue.name,
      description : formValue.description,
      patients : formValue.patients
    }
    console.log("Objet récupéré du formulaire");
    console.log("Study : " + study);

    this.studyService.create(study).subscribe({
      next: res => {
      console.log("Passage dans Service CREATE:");
      console.log("Id :" + study.id);
      console.log("Name :" + study.name);
      console.log("Description :" + study.description);
      console.log("liste des patients :" + study.patients);
      this.successMessage = `Etude "${res.name}" créée avec succès !`;
      this.errorMessage = '';
      this.createStudyForm.reset();
      this.cdr.markForCheck();
      },
      error: err => {
        console.error(err);
        this.successMessage = ``;
        this.errorMessage = "Problème lors de la création de l'étude";
      }
    });
  }
}
