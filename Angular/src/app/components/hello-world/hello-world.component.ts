import {Component, OnInit} from '@angular/core';
import {HelloWorldService} from '../../services/hello-world/hello-world.service';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent implements OnInit {
  message: string[];

  constructor(
    private helloWorldService: HelloWorldService,
  ) {
  }

  ngOnInit() {
    this.sayHi();
  }

  sayHi() {
    this.helloWorldService.sayHi().subscribe(hi => {
      this.message = hi;
    });
  }
}
