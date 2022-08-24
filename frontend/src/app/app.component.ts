import {Component, Inject, OnInit} from '@angular/core';
import {ApiService} from "./api/api.service";
import {Pasta, Setor} from "./models";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {

  setores: Array<Setor> = [];
  setorAtual?: Setor;
  pastas: Array<Pasta> = [];

  constructor(private readonly api: ApiService) {
  }

  async ngOnInit() {
    this.setores = await this.api.getSetores();
  }

  async getPastas(setor: Setor) {
    this.setorAtual = setor;
    this.pastas = []
    this.pastas = await this.api.getPastas(this.setorAtual.id);
  }
}
