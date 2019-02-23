  import { HttpParams, HttpHeaders } from '@angular/common/http';
  import { Injectable } from '@angular/core';

  import 'rxjs/add/operator/toPromise';

  import { environment } from './../../environments/environment';
  import { Produto, Categoria } from './../core/model';
  import { MoneyHttp } from '../seguranca/money-http';

  export class ProdutoFiltro {
    nome: string;
    pagina = 0;
    itensPorPagina = 5;
  }

  @Injectable()
  export class ProdutoService {

    produtoUrl: string;
    categoriaUrl: string;

    constructor(private http: MoneyHttp) {
      this.produtoUrl = `${environment.apiUrl}/produtos`;
      this.categoriaUrl = `${environment.apiUrl}/categorias`;
    }

    pesquisar(filtro: ProdutoFiltro): Promise<any> {
      let params = new HttpParams({
        fromObject: {
          page: filtro.pagina.toString(),
          size: filtro.itensPorPagina.toString()
        }
      });

      if (filtro.nome) {
        params = params.append('nome', filtro.nome);
      }

      return this.http.get<any>(`${this.produtoUrl}`, { params })
        .toPromise()
        .then(response => {
          const produtos = response.content;

          const resultado = {
            produtos,
            total: response.totalElements
          };

          return resultado;
        })
    }

    listarTodas(): Promise<any> {
      return this.http.get<any>(this.produtoUrl)
        .toPromise()
        .then(response => response.content);
    }

    buscarPorCodigo(codigo: number): Promise<Produto> {
      return this.http.get<Produto>(`${this.produtoUrl}/${codigo}`)
        .toPromise();
    }

    pesquisarCategorias(categoria): Promise<Categoria[]> {
      const params = new HttpParams()
        .append('categoria', categoria);

      return this.http.get<Categoria[]>(this.categoriaUrl, {
        params
      }).toPromise();
    }

    listarCategorias(): Promise<Categoria[]> {
      return this.http.get<Categoria[]>(this.categoriaUrl).toPromise();
    }

  }
