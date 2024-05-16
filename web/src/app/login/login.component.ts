import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/userService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(private router: Router, private userService: UserService) {
  }
  protected succesfulLogIn() {
    this.router.navigate(['homepage']);
  }
}
