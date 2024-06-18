import { Routes } from '@angular/router';
import { PantryComponent } from './pantry/pantry.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth/auth.guard';

export const routes: Routes = [
    { path: '', component: AppComponent },
    { path: 'login', component: LoginComponent},
    { path: 'pantry', component: PantryComponent, canActivate: [AuthGuard] }
];
