import {Component, Inject, OnInit} from '@angular/core';
import {ApiService} from "./api/api.service";
import {Setor} from "./models";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  setores: Array<Setor> = [];

  constructor(private readonly api: ApiService) {

  }

  async ngOnInit() {
    this.setores = await this.api.getSetores();
  }

}
