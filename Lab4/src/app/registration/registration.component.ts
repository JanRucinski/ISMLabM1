import { Component } from '@angular/core';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-registration',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.scss'
})
export class RegistrationComponent {
  onSubmit(form: NgForm) {
    if (form.valid) {
      fetch('localhost:8080/users/register', { method: 'POST', body: JSON.stringify(form.value) })

      console.log(form.value);
      
      form.reset();
    }
  }
  
}
