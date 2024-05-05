// event.model.ts

export interface Event {
    eventId: number;
    date: string; 
    time: string;
    location: string;
    approved: boolean;
  }