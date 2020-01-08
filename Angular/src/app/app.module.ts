import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HelloWorldComponent} from './components/hello-world/hello-world.component';
import {FooterComponent} from './components/footer/footer.component';
import {HeaderComponent} from './components/header/header.component';
import {AppRoutingModule} from './modules/routing/app-routing.module';
import {RouterModule} from '@angular/router';
import {AccountsComponent} from './components/accounts/accounts.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    FooterComponent,
    HeaderComponent,
    AccountsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
