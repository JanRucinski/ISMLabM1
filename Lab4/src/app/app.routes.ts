import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { EventComponent } from './event/event.component';
import { EventListComponent } from './event-list/event-list.component';

export const routes: Routes = [
    // {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegistrationComponent},
    {path: 'event-list', component: EventListComponent, children: [
        {path: ':eventId', component: EventComponent}
    ]}
];
