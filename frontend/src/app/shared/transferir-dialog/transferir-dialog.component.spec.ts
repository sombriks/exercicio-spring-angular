import {ComponentFixture, TestBed} from '@angular/core/testing';

import {TransferirDialogComponent} from './transferir-dialog.component';
import {AppModule} from "../../app.module";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

describe('TransferirDialogComponent', () => {
  let component: TransferirDialogComponent;
  let fixture: ComponentFixture<TransferirDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        AppModule
      ], providers: [
        {provide: MAT_DIALOG_DATA, useValue: {}},
        {provide: MatDialogRef, useValue: {}}
      ]
    })
      .compileComponents();

    fixture = TestBed.createComponent(TransferirDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
