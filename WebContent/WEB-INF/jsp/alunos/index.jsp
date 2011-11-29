<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table>

	<c:forEach items="${alunoList}" var="aluno">
		<tr>
			<td>${aluno.matricula}</td>
			<td>${aluno.nome}</td>
			<td><a href="aluno/${aluno.matricula}">ver aluno</a></td>
			<td>
				<form action="aluno/${aluno.matricula}" method="post"><input name="aluno.matricula" value="${aluno.matricula}" type="hidden" />
					<button type="submit" name="_method" value="DELETE">remover</button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
