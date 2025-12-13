import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User as userService} from '../../services/user';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-edit',
  imports: [CommonModule,FormsModule],
  templateUrl: './user-edit.html',
  styleUrl: './user-edit.css',
})
export class UserEdit {
  id !: string;
  user : any;
  userService = inject(userService);

  constructor(private route: ActivatedRoute) {}
  
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id')!;
    this.userService.getUserById(this.id).subscribe(data => {
      this.user = data;
    });
  }

  editUser() {
    this.userService.updateUser(this.id, this.user).subscribe(response => {
      console.log('User updated successfully', response);
      alert('User updated successfully');
    });
  }
}
