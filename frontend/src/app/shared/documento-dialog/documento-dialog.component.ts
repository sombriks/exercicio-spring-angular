import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Documento} from "../../models";

@Component({
  selector: 'app-documento-dialog',
  templateUrl: './documento-dialog.component.html',
  styleUrls: ['./documento-dialog.component.sass']
})
export class DocumentoDialogComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<DocumentoDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Documento) {
  }

  ngOnInit(): void {
  }

}
