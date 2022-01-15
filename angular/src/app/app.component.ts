import { Component } from '@angular/core';
import { ActivationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public activeRoute: string = '';

  constructor(router: Router) {
    router.events.subscribe(event => {
      if (event instanceof ActivationEnd) {
        if (event.snapshot.data['name']) {
          this.activeRoute = event.snapshot.data['name'];
        }
      }
    });
  }
}
