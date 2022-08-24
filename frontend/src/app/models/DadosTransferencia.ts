import Setor from "./Setor";
import Pasta from "./Pasta";
import {Documento} from "./index";

export default interface DadosTransferencia {
  setor: Setor;
  pasta: Pasta;
  documento: Documento;
}
