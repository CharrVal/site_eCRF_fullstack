import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { UserLoggedService } from '../../services/auth/user-logged-service';

@Component({
  selector: 'app-navbar',
  imports: [RouterLink, CommonModule],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar {

  constructor( private router: Router, public userLoggedService: UserLoggedService) {}

  logout() {
    this.userLoggedService.logout();
    sessionStorage.removeItem('Jwt'); 
    sessionStorage.removeItem('user');
    this.router.navigate(['/accueil']);
  }
}
