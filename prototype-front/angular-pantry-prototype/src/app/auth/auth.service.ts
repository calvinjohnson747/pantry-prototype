import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private authStatus = false;

  constructor(private http: HttpClient) {}

  login(name: string, password: string): Observable<boolean> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<any>('http://ec2-54-211-209-155.compute-1.amazonaws.com:8080/auth', { name: name, password: password }, { headers })
      .pipe(
        map(response => {
          if (response == true) {
            this.authStatus = true;
            return true;
          } else {
            return false;
          }
        }),
        catchError(() => of(false))
      );
  }

  logout(): void {
    this.authStatus = false;
  }

  isAuthenticated(): boolean {
    return this.authStatus;
  }
}
