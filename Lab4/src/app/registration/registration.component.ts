import { Component } from '@angular/core';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';  
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, CommonModule, RouterModule],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.scss'
})
export class RegistrationComponent {
  onSubmit(form: NgForm) {
    if (form.valid) {
      fetch('localhost:8080/api/users/register', { method: 'POST', body: JSON.stringify(form.value) })

      console.log(form.value);
      
      form.reset();
    }
  }
  
}
