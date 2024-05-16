import { Injectable } from "@angular/core";
import { Observable, catchError, map } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { Shop, IUser, IUserLogin, UserLogIn,CustomerSingUp, TransactionOfUser } from '../models/models';

@Injectable({
  providedIn: "root"
})
export class UserService {
  readonly DEPLOY_URL = "http://192.168.1.11:8080/"
  constructor(private http: HttpClient) { }

  getUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.DEPLOY_URL + "read_users");
  }
//do we ned this ;
  loginUser(userLogin: IUserLogin) {
    return this.http.post(this.DEPLOY_URL + "login", userLogin)
  }
//i changed this 
  logInUser(userLogIn: UserLogIn): Observable<UserLogIn> {
    return this.http.post<UserLogIn>(this.DEPLOY_URL + "signup",userLogIn)
  }
  customerSignUp(customerSignUp: CustomerSingUp):Observable<CustomerSingUp>{
    return this.http.post<CustomerSingUp>(this.DEPLOY_URL + "create_customer",customerSignUp)
  }

  getShopsNames(): Observable<Shop[]> {
    return this.http.get<Shop[]>(this.DEPLOY_URL + "shops")
  }
  getTransactions():Observable<TransactionOfUser[]>{
    return this.http.get<TransactionOfUser[]>(this.DEPLOY_URL + "transactions")
  }
  

}

