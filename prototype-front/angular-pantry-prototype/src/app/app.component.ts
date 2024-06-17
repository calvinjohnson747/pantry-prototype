import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Pantry 3427';
  username: String = '';
  password: String = '';
  loginMessage: String = '';

  constructor(private http:HttpClient){}

  login(): void{
    const user = {
      name : this.username,
      password : this.password
    };

  const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    
    this.http.post<string>('http://localhost:8080/auth', user, { headers })
      .subscribe(
        (response) => {
          this.loginMessage = response;
        },
        (error) => {
          this.loginMessage = 'Invalid Username or Password';
        }
      );
  }
}
