import { Injectable } from '@angular/core';
import { Visit } from '../../interfaces/visits/visit';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class VisitService {

  private apiUrl = "http://localhost:8080/visits"

  constructor ( private http: HttpClient){}

  getAll(): Observable<Visit[]> {
    return this.http.get<Visit[]>(this.apiUrl);
  }

  getById(id: number): Observable<Visit> {
    return this.http.get<Visit>(`${this.apiUrl}/${id}`);
  }

  getByPatientId(patientId: number): Observable<Visit[]> {
    return this.http.get<Visit[]>(`${this.apiUrl}/patient/${patientId}`)
  }

  create(formData: FormData) {
    return this.http.post<Visit>(this.apiUrl, formData);
  }

  update(id: number, formData: FormData) {
    return this.http.put<Visit>(`${this.apiUrl}/${id}`, formData)
  }

  delete(id:number) : Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`)
  }

}
