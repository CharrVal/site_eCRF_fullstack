import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Site } from "../../interfaces/sites/site";

@Injectable({
  providedIn: 'root',
})
export class SiteService {

  private apiUrl = "http://localhost:8080/sites"

  constructor ( private http: HttpClient){}

  getAll(): Observable<Site[]> {
    return this.http.get<Site[]>(this.apiUrl);
  }

  getById(id: number): Observable<Site> {
    return this.http.get<Site>(`${this.apiUrl}/${id}`);
  }

  getByStudyId(studyId: number): Observable<Site[]> {
    return this.http.get<Site[]>(`${this.apiUrl}/study/${studyId}`)
  }

  getBySiteId(siteId: number): Observable<Site[]> {
    return this.http.get<Site[]>(`${this.apiUrl}/site/${siteId}`)
  }

  createSite(study: Site): Observable<Site> {
    return this.http.post<Site>(this.apiUrl, study);
  }

  updateSite(id: number, study: Site): Observable<Site> {
    return this.http.put<Site>(`${this.apiUrl}/${id}`, study);
  }

  deleteSite(id: number) : Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}