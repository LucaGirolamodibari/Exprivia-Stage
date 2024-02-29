import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SignUp } from '../models/sign-up';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  hide = true;

  signUpData: SignUp = {
    utente: {
      email: '',
      password: ''
    },
    cliente: {
      nome: '',
      indirizzo: '',
      numTelefono: '',
      eta: 0
    }
  };

  constructor(private apiService: ApiService, private snackBar: MatSnackBar) { }

  register() {
    if (!this.signUpData.utente.email || !this.signUpData.utente.password || !this.signUpData.cliente.nome || !this.signUpData.cliente.indirizzo || !this.signUpData.cliente.eta || isNaN(this.signUpData.cliente.eta) || this.signUpData.cliente.eta <= 0) {
      this.showSnackBar('Per favore, compila tutti i campi obbligatori correttamente');
      return;
    }
  
    this.apiService.register(this.signUpData).subscribe({
      next: response => {
        console.log('Registrazione completata con successo:', response);
        this.showSnackBar('Registrazione completata con successo');
        this.resetFields();
      },
      error: error => {
        console.error('Errore durante la registrazione:', error);
        this.showSnackBar('Errore durante la registrazione');
      }
    });
  }
  

  resetFields() {
    this.signUpData = {
      utente: {
        email: '',
        password: ''
      },
      cliente: {
        nome: '',
        indirizzo: '',
        numTelefono: '',
        eta: 0
      }
    };
  }

  showSnackBar(message: string) {
    this.snackBar.open(message, 'Chiudi', {
      duration: 3000
    });
  }
}
