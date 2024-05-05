import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { EventDetails } from '../../interfaces/eventDetails';

import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  events: EventDetails[] = [];

  constructor(private http: HttpClient) { }

  addEvent() {
    const newEvent: EventDetails = {
      eventId: this.events.length + 1, // generate a new id
      date: '2022-01-01', // replace with actual date
      time: '12:00', // replace with actual time
      location: '123 Main St', // replace with actual location
      approved: true // replace with actual approval status
    };

  this.http.post('http://localhost:8080/events', newEvent)
    .subscribe(
      (response) => {
        console.log('Event added:', response);
      },
      (error) => {
        console.log('Error:', error);
      }
    );
}

}
