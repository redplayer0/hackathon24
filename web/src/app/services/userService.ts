import { Injectable } from "@angular/core";
import { User } from "../models/user";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class UserService {
  readonly ROOT_URL = "localhost:8080/";
  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.ROOT_URL + "read_users");
  }
}

