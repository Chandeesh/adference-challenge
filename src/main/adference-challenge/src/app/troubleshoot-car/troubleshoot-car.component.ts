import { Component, OnInit } from '@angular/core';
import { TroubleshootcarServiceService } from '../service/troubleshootcar-service.service';

@Component({
  selector: 'app-troubleshoot-car',
  templateUrl: './troubleshoot-car.component.html',
  styleUrls: ['./troubleshoot-car.component.css']
})
export class TroubleshootCarComponent implements OnInit {

  carservice: TroubleshootcarServiceService;
  question: string ;
  hidden: boolean ;

  constructor(carservice: TroubleshootcarServiceService) { 
    this.carservice = carservice;
  }

  ngOnInit(): void {
    this.carservice.getQuestion().subscribe((data) => {
      this.question = data;
      this.hidden = true;
    });
  }

  sendResponse(answer: string) {
    this.carservice.getQuestionOrAnswer(this.question, answer).subscribe((data) => {
      this.question = data.body['response'];
      if(data.body['lastNode']) {
        this.hidden = false;
        console.log(this.hidden);
      }
    });
  }
}
