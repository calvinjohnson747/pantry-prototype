import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  title = 'Pantry 3427';
  loginForm!: FormGroup;

  constructor(private http: HttpClient, private router: Router, private formBuilder: FormBuilder, private authService: AuthService){ 
    this.loginForm = this.formBuilder.group({
      name: [''],
      password: ['']
    });
   }

  login(): void{
    const {name, password} = this.loginForm.value;
    console.log(name,password);
    this.authService.login(name, password).subscribe(success => {
      if (success) {
        this.router.navigate(['/pantry']);
      } else {
        console.error('Wrong Password');
      }
    });
  }
}
