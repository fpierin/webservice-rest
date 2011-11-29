/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.caelum.vraptor.blank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.caelum.vraptor.view.Status;

@Resource
@Path("/alunos")
public class AlunosController {

	private final Result result;
	
	private final Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();

	public AlunosController(final Result result) {
		this.result = result;
		alunos.put(5875242, new Aluno(5875242, "Felipe Pierin", Sexo.Masculino));
		alunos.put(6875101, new Aluno(6875101, "Paulo Silva", Sexo.Masculino));		
	}

	@Path("/")
	public void lista() {
		result.use(Results.xml()).from(alunos.values()).serialize();
	}
	
	@Get
	@Path("/index")
	public List<Aluno> index() {
		final Collection<Aluno> values = alunos.values();
		final List<Aluno> lista = new ArrayList<Aluno>(values);
		return lista;
	}	

	@Post("/aluno")
	public void adiciona(final Aluno aluno) {
		alunos.put(aluno.getMatricula(), aluno);
	}

	@Get("/aluno/{aluno.matricula}")  
	public void visualiza(final Aluno aluno) {
		result.use(Results.xml()).from(alunos.get(aluno.getMatricula())).serialize();
	}

	@Delete("/aluno/{aluno.matricula}")
	public void remove(final Aluno aluno) {
		alunos.remove(aluno.getMatricula());
		result.use(Status.class).accepted();		
	}

	@Put("/aluno/{aluno.matricula}")
	public void atualiza(final Aluno aluno) {
		final Aluno alunoCadastrado = alunos.get(aluno.getMatricula());
		alunoCadastrado.setNome(aluno.getNome());
		alunoCadastrado.setSexo(aluno.getSexo());		
	}

}
