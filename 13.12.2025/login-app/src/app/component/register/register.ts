import { Component, inject } from '@angular/core';
import { RegisterModel } from '../../model/register/register-model.model';
import { FormsModule } from '@angular/forms';
import { RegisterService } from '../../service/register/register-service';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {
  registerModel: RegisterModel = new RegisterModel();
  registerService = inject(RegisterService);

  register() {
      this.registerService.register(this.registerModel).subscribe(
        (response) => {
          console.log('Registration successful', response);
          alert('Registration successful, please login now.');
        },
        (error) => {
          console.error('Registration failed', error);
        }
      );
  }
}
