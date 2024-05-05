import { Component } from '@angular/core';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  onSubmit(form: NgForm) {
    if (form.valid) {
      fetch('localhost:8080/api/users/login', { method: 'POST', body: JSON.stringify(form.value) })

      console.log(form.value);
      
      form.reset();
    }
  }

}
