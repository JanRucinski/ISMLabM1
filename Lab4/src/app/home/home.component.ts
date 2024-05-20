import { Component, OnInit, Renderer2 } from '@angular/core';
import { RouterModule } from '@angular/router';
import { EventDetails } from '../../interfaces/eventDetails';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  events: EventDetails[] = [];

  constructor(private http: HttpClient, private renderer: Renderer2) { }

  ngOnInit() {
    this.addJsonLdScript();
  }

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

  addJsonLdScript() {
    const jsonLd = {
      "@context": "http://schema.org",
      "@type": "WebPage",
      "headline": "Welcome to My Website",
      "description": "Home works! This is my web page using JSON-LD annotations",
      "mainEntity": {
        "@type": "Article",
        "headline": "Sample Article",
        "author": {
          "@type": "Person",
          "name": "Jan Ruciński"
        },
        "datePublished": "2024-05-17",
        "articleBody": "This is the body of the sample article.",
        "publisher": {
          "@type": "Organization",
          "name": "My Website"
        }
      }
    };
// do poprawy nie-static, type
    const script = this.renderer.createElement('script');
    script.type = 'application/ld+json';
    script.text = JSON.stringify(jsonLd);
    this.renderer.appendChild(document.head, script);
  }
}
