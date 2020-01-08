import {environment} from '../../environments/environment';

export class ApiUrls {
  public static HELLO_WORLD = `${environment.apiUrl}/`;
  public static ACCOUNT_GET_ALL = `${environment.apiUrl}/account/`;
  public static ACCOUNT_GET_BY_ID = `${environment.apiUrl}/account/findById`;
  public static ACCOUNT_GET_BY_EMAIL = `${environment.apiUrl}/account/findByEmail`;
}
