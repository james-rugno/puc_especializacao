export class Estado {
  codigo: number;
  nome: string;
}

export class Cidade {
  codigo: number;
  nome: string;
  estado = new Estado();
}

export class Endereco {
  logradouro: string;
  numero: string;
  complemento: string;
  bairro: string;
  cep: string;
  cidade = new Cidade();
}

export class Contato {
  codigo: number;
  nome: string;
  email: string;
  telefone: string;

  constructor(codigo?: number,
    nome?: string,
    email?: string,
    telefone?: string) {
      this.codigo = codigo;
      this.nome = nome;
      this.email = email;
      this.telefone = telefone;
  }
}

export class Pessoa {
  codigo: number;
  nome: string;
  endereco = new Endereco();
  ativo = true;
  contatos = new Array<Contato>();
}

export class Categoria {
  codigo: number;
  nome: string;
}

export class Fornecedor {
  codigo: number;
  razaoSocial: string;
  nomeFantasia: string;
  cnpj: number;
  endereco = new Endereco();
  ativo = true;
}

export class Produto {
  codigo: number;
  nome: string;
  descricao: string;
  valor: number;
  qtd: number;
  status: string;
  img1: string;
  img2: string;
  img3: string;
  img4: string;
  img5: string;
  categoria = new Categoria();
  fornecedor = new Fornecedor();
  ativo = true;
}

