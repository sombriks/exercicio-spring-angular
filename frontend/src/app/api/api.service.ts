import {Injectable} from '@angular/core';
import {Axios} from "axios";

import {environment} from "../../environments/environment";
import {Documento, Pasta, Setor} from "../models";

@Injectable()
export class ApiService {

  private readonly cli: Axios;

  constructor() {
    this.cli = new Axios({
      baseURL: environment.apiBaseUrl,
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
      }
    })
  }

  async getSetores(): Promise<Array<Setor>> {
    const result = await this.cli.get("/setores")
    return JSON.parse(result.data);
  }

  async getPasta(setorId: number, pastaId: number): Promise<Pasta> {
    const result = await this.cli.get(`/setores/${setorId}/pastas/${pastaId}`)
    return JSON.parse(result.data);
  }

  async getPastas(setorId?: number): Promise<Array<Pasta>> {
    const result = await this.cli.get(`/setores/${setorId}/pastas`)
    return JSON.parse(result.data);
  }

  async getDocumentos(setorId: number, pastaId: number): Promise<Array<Documento>> {
    const result = await this.cli.get(`/setores/${setorId}/pastas/${pastaId}/documentos`)
    return JSON.parse(result.data);
  }

  async salvarDocumento(setorId: number, pastaId: number, doc: any): Promise<Documento> {
    const path = `/setores/${setorId}/pastas/${pastaId}/documentos`;
    const result = await this.cli[doc.id ? "put" : "post"](path, JSON.stringify(doc));
    return JSON.parse(result.data);
  }
}
