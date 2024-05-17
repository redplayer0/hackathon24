import { Component, Injectable, OnInit } from '@angular/core';
import { UserService } from '../../services/userService';
import { IUser, IUserLogin, UserLogIn } from '../../models/models'; 

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {
  users: IUser[] = [];
  userLogIn = new UserLogIn()
  shops: string[] = []
  submitted = false;


  constructor(private userService: UserService) {
    this.getUsers()

    this.userService.getShopsNames().subscribe(shops => this.shops = shops.map((shop)=> shop.name));
  }

  onSubmit() { 
    this.submitted = true; 
    this.registerUser()
  }

  getUsers(): void {
    this.userService.getUsers()
      .subscribe(users => this.users = users);
  }

  registerUser(): void {
    this.userService.logInUser(this.userLogIn).subscribe(
      resp => {
        localStorage.setItem("mycookie", `${resp.headers.get("mycookie")}`)
      }
    )
  }
}