import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable()
export class TroubleshootcarServiceService {

  getquestion: string;
  getquestionoranswer: string;

  constructor(private http: HttpClient) {
    this.getquestion = 'http://localhost:8080/adference/getquestion';
    this.getquestionoranswer = 'http://localhost:8080/adference/getanswerorquestion?question=';
  }

  public getQuestion() {
    return this.http.get(this.getquestion,  {observe: 'response', responseType: 'text'}).pipe(map(response => {
      console.log(response.body);
      return response.body;
   }));
  }

  public getQuestionOrAnswer(question: string, answer: string) {
    return this.http.get(this.getquestionoranswer + question + '&answer=' + answer,  {observe: 'response'}).pipe(map(response => {
      return response;
   }));
  }

}
