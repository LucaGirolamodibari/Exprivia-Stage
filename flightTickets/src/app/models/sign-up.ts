export interface SignUp {
    utente: {
      email: string;
      password: string;
    };
    cliente: {
      nome: string;
      indirizzo: string;
      numTelefono: string;
      eta: number;
    };
  }
  