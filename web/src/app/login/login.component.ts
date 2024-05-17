import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { UserService } from '../services/userService';
import { IUser, IUserLogin, UserLogIn } from '../models/models'; 


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  users: IUser[] = [];
  userLogIn = new UserLogIn()
  shops: string[] = []
  submitted = false;


  constructor(private userService: UserService, private router: Router) {
    this.getUsers()

    this.userService.getShopsNames().subscribe(shops => this.shops = shops.map((shop)=> shop.name));
  }

  onSubmit() { 
    this.submitted = true; 
    this.registerUser()
    this.router.navigate(['/homepage']);
  }

  getUsers(): void {
    this.userService.getUsers()
      .subscribe(users => this.users = users);
      this.router.navigate(['/homepage']);
  }
  

  registerUser(): void {
    this.userService.logInUser(this.userLogIn).subscribe(
      resp => {
        localStorage.setItem("mycookie", `${resp.headers.get("mycookie")}`)
      }
    )
  }

}
