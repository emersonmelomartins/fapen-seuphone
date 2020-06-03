<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<f:form action="#" method="POST" modelAttribute="recebimentoForm">
	<div id="dadosRegistro">
		<table class="responsive-table striped">
			<thead>
				<tr>
					<th>Verificado</th>
					<th>Produto</th>
					<th>Quantidade</th>
					<th>Valor Unitário</th>
					<th>Valor Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${recebimentoForm.itens }" var="itemReceb"
					varStatus="status">

					<tr>
						<f:hidden path="itens[${status.index }].produto" />
						<f:hidden path="itens[${status.index }].valorTotal" />
						<td>
							<p>
								<label> <input type="checkbox" name="verificado" id="verificado" class="filled-in"
									/> <span></span>
								</label>
							</p>
						</td>
						<td>${itemReceb.produto.descricao }</td>
						<td>${itemReceb.quantidade }</td>
						<td>${itemReceb.precoUnitario }</td>
						<td>${itemReceb.valorTotal }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</f:form>