import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Prenotazione } from './models/prenotazione';
import { SignUp } from './models/sign-up';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8082';

  constructor(private http: HttpClient) {}

  addResource<T>(resourceName: string, data: T): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/${resourceName}/insert`, data);
  }

  getReservations(): Observable<Prenotazione[]> {
    return this.http.get<Prenotazione[]>(`${this.apiUrl}/prenotazioni`);
  }

  addReservation(reservation: Prenotazione): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/prenotazione/insert`, reservation);
  }

  updateReservation(reservation: Prenotazione): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/prenotazione/update/${reservation.idPrenotazione}`, reservation);
  }

  deleteReservation(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/prenotazione/delete/${id}`);
  }

  register(signUpData: SignUp): Observable<any> {
  return this.http.post<any>(`${this.apiUrl}/register`, signUpData);
}

  addFlight(flightData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/volo/insert`, flightData);
  }

  addAircraft(aircraftData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/aereo/insert`, aircraftData);
  }

  addClient(clientData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/cliente/insert`, clientData);
  }

  addUser(userData: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/utente/insert`, userData);
  }
  
  login(email: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, { email, password });
  }

  }
