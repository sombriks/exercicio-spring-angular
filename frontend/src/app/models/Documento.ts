import Pasta from "./Pasta";
import Situacao from "./Situacao";

export default interface Documento {
  id?: number;
  titulo: string;
  pasta?: Pasta;
  situacao?: Situacao;
}
