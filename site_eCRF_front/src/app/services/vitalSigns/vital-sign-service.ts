import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { VitalSign } from '../../interfaces/vitalsign/vitalSign';

@Injectable({
  providedIn: 'root',
})
export class VitalSignService {

  private apiUrl = "http://localhost:8080/vitalSigns"

  constructor ( private http: HttpClient){}

  getAll(): Observable<VitalSign[]> {
    return this.http.get<VitalSign[]>(this.apiUrl);
  }

  getById(id: number): Observable<VitalSign> {
    return this.http.get<VitalSign>(`${this.apiUrl}/${id}`);
  }

  getByVisitId(visitId: number): Observable<VitalSign[]> {
    return this.http.get<VitalSign[]>(`${this.apiUrl}/visit/${visitId}`)
  }

  create(formData: FormData) {
    return this.http.post<VitalSign>(this.apiUrl, formData);
  }

  update(id: number, formData: FormData) {
    return this.http.put<VitalSign>(`${this.apiUrl}/${id}`, formData)
  }

  delete(id:number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`)
  }

}
