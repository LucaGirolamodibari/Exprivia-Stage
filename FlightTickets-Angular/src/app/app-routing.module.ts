import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { HomeComponent } from './home/home.component';
import { InserimentoComponent } from './inserimento/inserimento.component';
import { PrenotazioneComponent } from './prenotazione/prenotazione.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent }, 
  { path: 'signup', component: SignUpComponent }, 
  { path: 'home', component: HomeComponent }, 
  { path: 'inserimento', component: InserimentoComponent }, 
  { path: 'prenotazione', component: PrenotazioneComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
