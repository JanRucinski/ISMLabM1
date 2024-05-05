import { Component, NgModule, OnInit } from '@angular/core';
import { EventDetails } from '../../interfaces/eventDetails';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-event-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.scss'
})
export class EventListComponent implements OnInit {
  // addEvent() {
  //   const newEvent: EventDetails = {
  //     eventId: this.events.length + 1, // generate a new id
  //     date: '2022-01-01', // replace with actual date
  //     time: '12:00', // replace with actual time
  //     location: '123 Main St', // replace with actual location
  //     approved: true // replace with actual approval status
  //   };
  
  //   this.events.push(newEvent);
  
  //   console.log('Event added:', newEvent);
  // }

constructor(private http: HttpClient) { }

addEvent() {
    const newEvent: EventDetails = {
      eventId: this.events.length + 1, // generate a new id
      date: '2022-01-01', // replace with actual date
      time: '12:00', // replace with actual time
      location: '123 Main St', // replace with actual location
      approved: true // replace with actual approval status
    };

  this.http.post('http://localhost:8080/api/events', newEvent)
    .subscribe(
      (response) => {
        console.log('Event added:', response);
        this.populateEvents(); // refresh the events list
      },
      (error) => {
        console.log('Error:', error);
      }
    );
}

  events: EventDetails[] = [];

  ngOnInit(): void {
    this.populateEvents();
  }

  populateEvents() {
    this.http.get('http://localhost:8080/api/events')
    .subscribe(
      (response: any) => {
        this.events = response;
      },
      (error) => {
        console.log('Error:', error);
      }
    );
    console.log('Populating events...');
    // fetch('localhost:8080/events')
    //   .then(response => response.json())
    //   .then(data => {
    //     this.events = data;
    //   });

    // populate events with dummy data
    // this.events = [
    //   { eventId: 1, date: '2020-01-01', time: '12:00', location: '123 Main St', approved: true },
    //   { eventId: 2, date: '2020-01-02', time: '13:00', location: '456 Elm St', approved: true },
    //   { eventId: 3, date: '2020-01-03', time: '14:00', location: '789 Oak St', approved: false },
    //   { eventId: 4, date: '2020-01-04', time: '15:00', location: '1011 Pine St', approved: true },
    //   { eventId: 5, date: '2020-01-05', time: '16:00', location: '1213 Cedar St', approved: false }
    // ];
  }


}
