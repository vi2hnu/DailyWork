import { Component,inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../../services/user' ;
import { User as userModel } from '../../model/user.model';

@Component({
  selector: 'app-user-add',
  imports: [FormsModule],
  templateUrl: './user-add.html',
  styleUrl: './user-add.css',
})
export class UserAdd {
  userService = inject(User);
  user :userModel = new userModel(); 

  addUser() {
    this.userService.addUser(this.user).subscribe(() => {
      console.log(this.user);
      alert('User added');
    });
  }
}
