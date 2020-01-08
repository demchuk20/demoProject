import {Component, OnInit} from '@angular/core';
import {Account} from '../../models/entity/account';
import {AccountsService} from '../../services/accounts/accounts.service';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {
  account: Account;
  accounts: Account[];

  constructor(private accountsService: AccountsService) {
  }

  ngOnInit() {
    this.getAllAccounts();
  }

  getAccountById(id: number) {
    this.accountsService.getAccountById(id).subscribe(accounts => {
      this.account = accounts;
    });
  }

  getAccountByEmail(email: string) {
    this.accountsService.getAccountByEmail(email).subscribe(accounts => {
      this.account = accounts;
    });
  }

  getAllAccounts() {
    this.accountsService.getAllAccounts().subscribe(next => {
      this.accounts = next;
    });
  }
}
