import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent implements OnInit{
  user: { id: number; email: string; name: string }[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchUsers();
  }

  fetchUsers() {
    // Use an inline type definition for the response
      this.http.get<{ id: number; email: string; name: string }[]>('http://localhost:8081/api/users')
        .subscribe({
           next: (data) => {
            this.user = data; // Assign the fetched data to the users array
            },
          error: (error) => {
            console.error('Error fetching users', error);
           }});
}}