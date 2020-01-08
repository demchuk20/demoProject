import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiUrls} from '../../const/api-urls';

@Injectable({
  providedIn: 'root'
})
export class HelloWorldService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  public sayHi(): Observable<string[]> {
    console.log();
    return this.httpClient.get<string[]>(ApiUrls.HELLO_WORLD);
  }
}
