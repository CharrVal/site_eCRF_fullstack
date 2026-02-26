import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from '../../interfaces/patients/patient';

@Injectable({
  providedIn: 'root',
})
export class PatientService {

  private apiUrl = "`http://localhost:8080/patients"

  constructor(private http: HttpClient) {}

  getAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.apiUrl);
  }

  getById(id: number): Observable<Patient> {
    return this.http.get<Patient>(`${this.apiUrl}/${id}`);
  }

  create(formData: FormData) {
    return this.http.post<Patient>(this.apiUrl, formData);
  }

  update(id: number, formData: FormData): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, formData);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

}
