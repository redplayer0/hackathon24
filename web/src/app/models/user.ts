export class UserRegister {
  constructor(
    public email: string = "",
    public password: string = "",
    public role: string = "",
  ) {}
}

export interface IUser {
  id: number;
  email: string;
  password: string;
  role: string;
}

export interface IUserLogin {
  email: string;
  password: string;
}
