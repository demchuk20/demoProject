import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Account} from '../../models/entity/account';
import {ApiUrls} from '../../const/api-urls';

@Injectable({
  providedIn: 'root'
})
export class AccountsService {

  constructor(
    private  httpClient: HttpClient
  ) {
  }

  public getAllAccounts(): Observable<Account[]> {
    console.log();
    return this.httpClient.get <Account[]>(ApiUrls.ACCOUNT_GET_ALL);
  }

  public getAccountById(id: number): Observable<Account> {
    console.log();
    const params = new HttpParams()
      .set('id', String(id));
    return this.httpClient.get<Account>(ApiUrls.ACCOUNT_GET_BY_ID, {params});
  }

  public getAccountByEmail(email: string): Observable<Account> {
    console.log();
    const params = new HttpParams()
      .set('email', email);
    return this.httpClient.get<Account>(ApiUrls.ACCOUNT_GET_BY_EMAIL, {params});
  }

}
