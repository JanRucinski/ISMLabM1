import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventDetails } from '../../interfaces/eventDetails';

@Component({
  selector: 'app-event',
  standalone: true,
  imports: [],
  templateUrl: './event.component.html',
  styleUrl: './event.component.scss'
})
export class EventComponent implements OnInit{
  event: EventDetails | null = null;

  constructor(private route: ActivatedRoute) { }
  
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const eventId = +params['id']; 
      this.populateEvent(eventId);
    });
  }

  populateEvent(eventId: number) {
    fetch(`localhost:8080/events/${eventId}`)
      .then(response => response.json())
      .then(data => {
        this.event = data;
      });
  }

}
