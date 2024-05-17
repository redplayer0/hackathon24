import { Injectable } from "@angular/core";
import { Observable, catchError, map } from "rxjs";
import { HttpClient, HttpHeaders, HttpResponse, HttpStatusCode } from "@angular/common/http";
import { Shop, IUser, IUserLogin, UserLogIn, CustomerSingUp, TransactionOfUser, ShopSingUp } from '../models/models';

@Injectable({
  providedIn: "root"
})
export class UserService {
  readonly DEPLOY_URL = "http://192.168.138.148:8080/"
  constructor(private http: HttpClient) { }

  getUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.DEPLOY_URL + "read_users");
  }

  //i changed this 
  logInUser(userLogIn: UserLogIn): Observable<HttpResponse<UserLogIn>> {
    return this.http.post<UserLogIn>(this.DEPLOY_URL + "signup", userLogIn, { observe: 'response' })
  }

  customerSignUp(customerSignUp: CustomerSingUp): Observable<CustomerSingUp> {
    return this.http.post<CustomerSingUp>(this.DEPLOY_URL + "create_customer", customerSignUp)
  }
  shopSignUp(shopSignUp: ShopSingUp): Observable<ShopSingUp> {
    return this.http.post<ShopSingUp>(this.DEPLOY_URL + "create_shop", shopSignUp)
  }

  getShopsNames(): Observable<Shop[]> {
    return this.http.get<Shop[]>(this.DEPLOY_URL + "shops")
  }
  getTransactions(): Observable<TransactionOfUser[]> {
    // localStorage.setItem("mycookie", "d3d3OnRlc3Q=")
    const headers = new HttpHeaders({
      'mycookie': `${localStorage.getItem("mycookie")}`
    });
    return this.http.get<TransactionOfUser[]>(this.DEPLOY_URL + "transactions", { headers: headers })
  }


}