import { Routes } from '@angular/router';
import { Login } from './component/login/login';
import { Register } from './component/register/register';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: Login },
  { path: 'register', component: Register },
  { path: '**', redirectTo: '/login' }
];
