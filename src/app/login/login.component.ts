import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email: string = '';
  password: string = '';

  constructor(private apiService: ApiService, private router: Router) { }

  login() {
    this.apiService.login(this.email, this.password).subscribe({
      next: (_response) => {
        this.router.navigateByUrl('home');
      },
      error: (error) => {
        console.error(error);
        alert('Credenziali non valide. Riprova.');
      }
    });
  }
}
