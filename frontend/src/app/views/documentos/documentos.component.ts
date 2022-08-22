import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Observable, switchMap} from "rxjs";

import {Documento} from "../../models";
import {ApiService} from "../../api/api.service";

@Component({
  selector: 'app-documentos',
  templateUrl: './documentos.component.html',
  styleUrls: ['./documentos.component.sass']
})
export class DocumentosComponent implements OnInit {

  documentos?: Documento[];

  constructor(private route: ActivatedRoute, private api: ApiService) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(async next => {
      const setorId = parseInt(<string>next.get("setorId"));
      const pastaId = parseInt(<string>next.get("pastaId"));
      console.log(setorId, pastaId);
      this.documentos = await this.api.getDocumentos(setorId, pastaId);
    })
  }

}
