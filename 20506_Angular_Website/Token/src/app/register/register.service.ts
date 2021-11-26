import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  private docUrl = 'http://localhost:8080/doctor/add'
  private patUrl = 'http://localhost:8080/patient/add'

  constructor(private http: HttpClient) { }

  addDoc(req: any): Observable<any> {
    let headers = { 'content-type': 'Application/JSON' }
    let body = JSON.stringify(req)
    return this.http.post(this.docUrl, body, { 'headers': headers })
  }


  patDoc(req: any): Observable<any> {
    let headers = { 'content-type': 'Application/JSON' }
    let body = JSON.stringify(req)
    return this.http.post(this.patUrl, body, { 'headers': headers })
  }


  errorHandler(error: HttpErrorResponse) {
    throw throwError(HttpErrorResponse);
  }

}
