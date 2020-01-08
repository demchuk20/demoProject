import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {HelloWorldComponent} from '../../components/hello-world/hello-world.component';
import {AccountsComponent} from '../../components/accounts/accounts.component';

const routes: Routes = [
  {path: '', component: HelloWorldComponent},
  {path: 'accounts', component: AccountsComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
