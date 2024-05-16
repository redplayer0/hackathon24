import { Injectable } from "@angular/core";
import { Observable, catchError, map } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { Shop, IUser, IUserLogin, UserRegister } from '../models/user';

@Injectable({
  providedIn: "root"
})
export class UserService {
  readonly DEPLOY_URL = "http://192.168.138.148:8080/"
  constructor(private http: HttpClient) { }

  getUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.DEPLOY_URL + "read_users");
  }

  loginUser(userLogin: IUserLogin) {
    return this.http.post(this.DEPLOY_URL + "login", userLogin)
  }

  registerUser(userRegister: UserRegister): Observable<UserRegister> {
    return this.http.post<UserRegister>(this.DEPLOY_URL + "signup", userRegister)
  }

  getShopsNames(): Observable<Shop[]> {
    return this.http.get<Shop[]>(this.DEPLOY_URL + "shops")
  }

}

