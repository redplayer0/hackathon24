import { Injectable } from "@angular/core";
import { Observable, catchError } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { IUser, IUserLogin, UserRegister } from '../models/user'; 

@Injectable({
  providedIn: "root"
})
export class UserService {
  readonly ROOT_URL = "http://localhost:8080/";
  constructor(private http: HttpClient) { }

  getUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.ROOT_URL + "read_users");
  }

  loginUser(userLogin: IUserLogin) {
    return this.http.post(this.ROOT_URL + "login", userLogin)
  }

  registerUser(userRegister: UserRegister): Observable<UserRegister> {
    return this.http.post<UserRegister>(this.ROOT_URL + "signup", userRegister)
  }

}

