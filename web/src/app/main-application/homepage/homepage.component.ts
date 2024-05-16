import { Component, Injectable, OnInit } from '@angular/core';
import { UserService } from '../../services/userService';
import { IUser, IUserLogin, UserRegister } from '../../models/user'; 

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {
  users: IUser[] = [];
  userRegister = new UserRegister()
  submitted = false;


  constructor(private userService: UserService) {
    this.getUsers()
    console.log(this.userService.loginUser({
      "email": "another1",
      "password": "test"
    }))
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
    this.userService.registerUser(this.userRegister).subscribe(user => console.log(user))
  }
}
