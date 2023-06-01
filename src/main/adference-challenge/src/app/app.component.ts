import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'adference-challenge';
  state: string;
  router: Router;

  constructor(route: ActivatedRoute, router: Router) {
    this.router = router;
  }

  start(){
    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;
    }
    this.router.onSameUrlNavigation = 'reload';
    this.router.navigateByUrl('/troubleshootcar');
  }

}
