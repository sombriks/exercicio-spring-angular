import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Observable, switchMap} from "rxjs";

import {Documento, Pasta} from "../../models";
import {ApiService} from "../../api/api.service";
import {MatDialog} from "@angular/material/dialog";
import {
  DocumentoDialogComponent
} from "../../shared/documento-dialog/documento-dialog.component";

@Component({
  selector: 'app-documentos',
  templateUrl: './documentos.component.html',
  styleUrls: ['./documentos.component.sass']
})
export class DocumentosComponent implements OnInit {

  pasta: Pasta = {nome: "Carregando..."};
  documentos: Documento[] = [];
  setorId: number = 0;
  pastaId: number = 0;

  constructor(
    private route: ActivatedRoute,
    private api: ApiService,
    public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.listar();
  }


  listar(): void {
    this.route.paramMap.subscribe(async next => {
      this.setorId = parseInt(<string>next.get("setorId"));
      this.pastaId = parseInt(<string>next.get("pastaId"));
      this.pasta = await this.api.getPasta(this.setorId, this.pastaId);
      this.documentos = await this.api.getDocumentos(this.setorId, this.pastaId);
    });
  }

  novo(doc: Documento = {titulo: "Novo documento"}): void {
    this.dialog.open(DocumentoDialogComponent, {
      data: doc,
      width: "50%"
    }).afterClosed().subscribe(async result => {
      await this.api.salvarDocumento(this.setorId, this.pastaId, result);
      this.listar();
    });
  }

}
