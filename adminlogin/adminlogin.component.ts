import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { Router, RouterLink, RouterModule } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  imports: [CommonModule,RouterModule,FormsModule,HttpClientModule],
  templateUrl: './adminlogin.component.html',
  styleUrl: './adminlogin.component.css'
})
export class AdminloginComponent {

  email: string = '';
  password: string = '';
  errorMessage: string = '';

  private apiUrl = 'http://localhost:8081/api/adminlogin'; // Adjust the URL as needed

  constructor(private http: HttpClient, private router: Router) { }

  login() {
    const body = { email: this.email, password: this.password };

    this.http.post<any>(this.apiUrl, body, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    }).subscribe({
      next: (admin) => {
        console.log('Login successful', admin);
        // Navigate to a different page or store user info
        this.router.navigate(['/admin-dashboard']); // Adjust the route as necessary
      },
      error: (err) => {
        console.error('Login failed', err);
        this.errorMessage = 'Invalid email or password';
      }
    });
  }



}
