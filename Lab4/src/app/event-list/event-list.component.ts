import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-list',
  standalone: true,
  imports: [],
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.scss'
})
export class EventListComponent implements OnInit{
  events: Event[] = [];

  ngOnInit(): void {
    this.populateEvents();
  }

  populateEvents() {
    fetch('localhost:8080/events')
      .then(response => response.json())
      .then(data => {
        this.events = data;
      });
  }
  

}
