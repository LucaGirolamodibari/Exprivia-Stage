import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { MatDialog } from '@angular/material/dialog';
import { Volo } from '../models/volo';
import { Cliente } from '../models/cliente';
import { Utente } from '../models/utente';
import { Aereo } from '../models/aereo';
import { MatSnackBar } from '@angular/material/snack-bar';

interface Entities {
  volo: Volo[];
  cliente: Cliente[];
  utente: Utente[];
  aereo: Aereo[];
}

@Component({
  selector: 'app-inserimento',
  templateUrl: './inserimento.component.html',
  styleUrls: ['./inserimento.component.css'],
})
export class InserimentoComponent implements OnInit {
  entities: Entities = {
    volo: [],
    cliente: [],
    utente: [],
    aereo: [],
  };
  selectedEntity: any = {}; // Inizializza come oggetto vuoto
  // Definizione di oggetti selezionati per diverse entità
  selectedVolo = {
    idVolo: 0,
    idAeroportoOrigine: 0,
    idAeroportoDestinazione: 0,
    idAeroportoScalo: 0,
    idAereo: 0,
    postiPrenotati: 0,
    postiDisponibili: 0,
    costoBase: 0,
  };
  selectedCliente = {
    idCliente: 0,
    nome: '',
    indirizzo: '',
    numTelefono: '',
    eta: 0,
  };
  selectedAereo = {
    idAereo: 0,
    idCompagnia: 0,
    modello: '',
    stato: 1,
    postiTotali: 0,
    capienzaMerci: 0,
    note: '',
  };
  selectedUtente = { idCliente: 0, email: '', password: '' };
  showForm: boolean = false;

  constructor(private apiService: ApiService, private dialog: MatDialog, private snackbar: MatSnackBar) {}
  
  ngOnInit(): void {
    this.getData('volo');
    this.getData('cliente');
    this.getData('utente');
    this.getData('aereo');
  }

  getData(entityType: keyof Entities): void {
    const methodName = `get${entityType.charAt(0).toUpperCase() + entityType.slice(1)}s`;
    (this.apiService as any)[methodName]().subscribe((data: any[]) => {
      this.entities[entityType] = data;
    });
  }

  submitForm(entityType: string): void {
    if (this.selectedEntity.id === 0) {
      const methodName = `add${entityType.charAt(0).toUpperCase() + entityType.slice(1)}`;
      (this.apiService as any)[methodName](this.selectedEntity).subscribe(() => {
        this.getData(entityType as keyof Entities);
        this.clearForm();
        this.showSnackbarMessage('Inserimento riuscito!');
      }, () => {
        this.showSnackbarMessage('Errore durante l\'inserimento. Si prega di riprovare.');
      });
    } else {
      const methodName = `update${entityType.charAt(0).toUpperCase() + entityType.slice(1)}`;
      (this.apiService as any)[methodName](this.selectedEntity).subscribe(() => {
        this.getData(entityType as keyof Entities);
        this.clearForm();
      });
    }
  }
  

  clearForm(): void {
    this.selectedEntity = {};
    this.showForm = false;
  }

  // Metodo per gestire il cambio di entità selezionata
  handleEntityChange(entityType: string): void {
    // Imposta selectedEntity in base all'entità selezionata
    switch (entityType) {
      case 'volo':
        this.selectedEntity = this.selectedVolo;
        break;
      case 'cliente':
        this.selectedEntity = this.selectedCliente;
        break;
      case 'aereo':
        this.selectedEntity = this.selectedAereo;
        break;
      case 'utente':
        this.selectedEntity = this.selectedUtente;
        break;
      default:
        this.selectedEntity = {};
        break;
    }
    // Mostra il form
    this.showForm = true;
  }
  private showSnackbarMessage(message: string): void {
    this.snackbar.open(message, 'Chiudi', {
      duration: 3000, // Durata del messaggio in millisecondi
    });
  }
}
