import { Injectable } from "@angular/core";
import { Observable, catchError, map } from "rxjs";
import { HttpClient, HttpHeaders, HttpResponse, HttpStatusCode } from "@angular/common/http";
import { Shop, IUser, IUserLogin, UserLogIn, CustomerSingUp, TransactionOfUser, ShopSingUp } from '../models/models';

@Injectable({
  providedIn: "root"
})
export class UserService {
  readonly DEPLOY_URL = "http://192.168.140.148:8080/"
  constructor(private http: HttpClient) { }

  getUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.DEPLOY_URL + "read_users");
  }

  //i changed this 
  logInUser(userLogIn: UserLogIn): Observable<HttpResponse<UserLogIn>> {

    return this.http.post<UserLogIn>(this.DEPLOY_URL + "signup", userLogIn, { observe: 'response' })
  }

  customerSignUp(customerSignUp: CustomerSingUp): Observable<CustomerSingUp> {
    const headers = new HttpHeaders({
      'mycookie': `${localStorage.getItem("mycookie")}`
    });

    return this.http.post<CustomerSingUp>(this.DEPLOY_URL + "create_customer", customerSignUp, { headers: headers })
  }
  shopSignUp(shopSignUp: ShopSingUp): Observable<ShopSingUp> {
    const headers = new HttpHeaders({
      'mycookie': `${localStorage.getItem("mycookie")}`
    });
    return this.http.post<ShopSingUp>(this.DEPLOY_URL + "create_shop",shopSignUp,{ headers: headers })
  }

  getShopsNames(): Observable<Shop[]> {
    const headers = new HttpHeaders({
      'mycookie': `${localStorage.getItem("mycookie")}`
    });
    return this.http.get<Shop[]>(this.DEPLOY_URL + "shops",{ headers: headers })
  }
  getTransactions(): Observable<TransactionOfUser[]> {
    localStorage.setItem("mycookie", "dGVzdGN1c3RvbWVyQG1haWwuY29tOmN1c3RvbWVy")
    const headers = new HttpHeaders({
      'mycookie': `${localStorage.getItem("mycookie")}`
    });
    return this.http.get<TransactionOfUser[]>(this.DEPLOY_URL + "transactions", { headers: headers })
  }

  
  // fetchshopName(name: string) {
  //   if (!this.) {
  //     this.hero = this.heroService.getHeroById(id);
  //   }
  //   return this.hero;
  // }


}