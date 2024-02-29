import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Prenotazione } from '../models/prenotazione';
import { MatDialog } from '@angular/material/dialog'; 

@Component({
  selector: 'app-prenotazione',
  templateUrl: './prenotazione.component.html',
  styleUrls: ['./prenotazione.component.css']
})
export class PrenotazioneComponent implements OnInit {
  reservations: Prenotazione[] = [];
  selectedReservation: Prenotazione = { idPrenotazione: 0, idVolo: '', idCliente: 0, dataPrenotazione: new Date(), dataViaggio: new Date(), costoFatturato: 0, nomeGiorno: '' };
  showForm: boolean = false;
  
  displayedColumns: string[] = ['idPrenotazione', 'idVolo', 'idCliente', 'dataPrenotazione', 'dataViaggio', 'costoFatturato', 'nomeGiorno', 'actions'];

  constructor(private reservationService: ApiService, private dialog: MatDialog) {}


  ngOnInit(): void {
    this.getReservations();
  }

  getReservations(): void {
    this.reservationService.getReservations()
      .subscribe(reservations => this.reservations = reservations);
  }

  editReservation(reservation: Prenotazione): void {
    this.selectedReservation = { ...reservation };
    this.showForm = true;
  }

  deleteReservation(id: number): void {
    this.reservationService.deleteReservation(id)
      .subscribe(() => {
        // Aggiorna la lista delle prenotazioni dopo l'eliminazione
        this.getReservations();
      });
  }

  submitForm(): void {
    if (this.selectedReservation.idPrenotazione === 0) {
      // Inserimento: Invia una richiesta HTTP POST per aggiungere una nuova prenotazione
      this.reservationService.addReservation(this.selectedReservation)
        .subscribe(() => {
          // Aggiorna la lista delle prenotazioni dopo l'inserimento
          this.getReservations();
          // Resettare selectedReservation per consentire nuovi inserimenti
          this.clearForm();
        });
    } else {
      // Aggiornamento: Invia una richiesta HTTP PUT per aggiornare la prenotazione esistente
      this.reservationService.updateReservation(this.selectedReservation)
        .subscribe(() => {
          // Aggiorna la lista delle prenotazioni dopo l'aggiornamento
          this.getReservations();
          // Resettare selectedReservation dopo l'aggiornamento
          this.clearForm();
        });
    }
  }

  clearForm(): void {
    // Resettare selectedReservation per consentire nuovi inserimenti/modifiche
    this.selectedReservation = { idPrenotazione: 0, idVolo: '', idCliente: 0, dataPrenotazione: new Date(), dataViaggio: new Date(), costoFatturato: 0, nomeGiorno: '' };
    this.showForm = false;
  }
}
