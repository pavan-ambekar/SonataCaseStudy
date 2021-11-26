import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private patUrl = 'http://localhost:8080/patient/getpassword'
  private docUrl = 'http://localhost:8080/doctor/getpassword'

  constructor(private http: HttpClient) { }

  docLogin(req: any): Observable<any> {
    const headers = { 'content-type': 'application/json' }
    const body = JSON.stringify(req);
    return this.http.post(this.docUrl, body, { 'headers': headers })
  }
  patLogin(req: any): Observable<any> {
    const headers = { 'content-type': 'application/json' }
    const body = JSON.stringify(req);
    return this.http.post(this.patUrl, body, { 'headers': headers })
  }
  errorHandler(error: HttpErrorResponse) {
    throw throwError(HttpErrorResponse);
  }
}
