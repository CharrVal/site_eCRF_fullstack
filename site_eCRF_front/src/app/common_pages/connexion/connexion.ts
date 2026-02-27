import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-connexion',
  imports: [RouterModule, CommonModule, ReactiveFormsModule],
  templateUrl: './connexion.html',
  styleUrl: './connexion.css',
})
export class Connexion {

  connexionForm : FormGroup;
  errorMessage: string | null = null;

  constructor(private fb : FormBuilder,) {
    this.connexionForm = this.fb.group({
      identifiant: ['',Validators.required],
      password: ['',Validators.required]
    });
  }

  connecter() {
    return "not implemented";
  }
}
