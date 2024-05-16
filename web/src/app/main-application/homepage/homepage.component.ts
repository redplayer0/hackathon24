import { HttpClient } from '@angular/common/http';
import { Component, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../../models/user'; 
import { UserService } from '../../services/userService';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css'
})
export class HomepageComponent {
  users: User[] = [];
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    console.log("HI")
    this.getUsers()
    console.log(this.users)
  }

  getUsers(): void {
    this.userService.getUsers()
      .subscribe(users => this.users = users);
  }

}
