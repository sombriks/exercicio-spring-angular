import {Component, Inject, OnInit} from '@angular/core';

import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Documento, Pasta, Setor} from "../../models";
import {ApiService} from "../../api/api.service";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-transferir-dialog',
  templateUrl: './transferir-dialog.component.html',
  styleUrls: ['./transferir-dialog.component.sass']
})
export class TransferirDialogComponent implements OnInit {

  setores: Setor[] = [];
  pastas: Pasta[] = [];

  setorControl = new FormControl<Setor | ''>('');
  pastaControl = new FormControl<Pasta | ''>('');

  constructor(
    private api: ApiService,
    @Inject(MAT_DIALOG_DATA) public data: Documento,
    public dialogRef: MatDialogRef<TransferirDialogComponent>
  ) {
  }

  async ngOnInit() {
    this.setores = await this.api.getSetores()

    this.setorControl.valueChanges.subscribe(async (value) => {
      this.pastaControl.setValue("");
      if (value && value.id) {
        this.pastas = await this.api.getPastas(value.id);
      } else {
        this.pastas = [];
      }
    });

    this.pastaControl.valueChanges.subscribe(async (value) => {
      if (value && value.id) {
        this.data.pasta = value;
      }
    });
  }

  displayFn(v = {nome: ""}) {
    return v.nome;
  }

}
