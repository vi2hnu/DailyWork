import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from '../../services/user';
import { User as userModel } from '../../model/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  imports: [CommonModule],
  templateUrl: './user-list.html',
  styleUrl: './user-list.css',
})

export class UserList implements OnInit {
  userService = inject(User);
  users: userModel[] = [];

  constructor(private router: Router) {}


  ngOnInit() {
    this.userService.getUsers().subscribe(data => {
      this.users = data;
    });
  }

  deleteUser(id: string) {
    this.userService.deleteUser(id).subscribe(() => {
      this.users = this.users.filter(user => user.id !== id);
    });
  }

  editUser(id: string) {
    this.router.navigate(['/edit', id]);
  }
  
}
