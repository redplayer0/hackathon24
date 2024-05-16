import { Component, Injectable, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { UserService } from '../../services/userService';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {
  users: User[] = [];

  constructor(private userService: UserService) {
    this.getUsers()
  }

  getUsers(): void {
    this.userService.getUsers()
      .subscribe(users => this.users = users);
  }
}
