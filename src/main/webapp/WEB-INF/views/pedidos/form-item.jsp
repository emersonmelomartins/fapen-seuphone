<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<f:form action="#" method="POST" modelAttribute="pedidoCompraForm" >
	<div id="dadosRegistro">
		<c:forEach items="${pedidoCompraForm.itensPedidoCompra}" var="itemPedido" varStatus="status">
		
			<div class="card">
				<div class="card-content">
					<f:hidden path="itensPedidoCompra[${status.index}].idDescricao"/>
					<f:hidden path="itensPedidoCompra[${status.index}].pedido"/>
					<div class="row">
						<div class="input-field col s4">
							<f:select path="itensPedidoCompra[${status.index}].produto" cssClass="validate">
								<f:option value="">Selecione</f:option>
								<f:options items="${listaProdutos}" itemValue="idProduto" itemLabel="descricao"/>
							</f:select>												
							<label class="active" for="itensPedidoCompra[${status.index}].produto">Produto</label>
							<f:errors path="itensPedidoCompra[${status.index}].produto" cssClass="helper-text" />
						</div>
						
						<div class="input-field col s3">
							<f:input type="number" path="itensPedidoCompra[${status.index}].quantidade" cssClass="validate" />
							<label class="active" for="itensPedidoCompra[${status.index}].quantidade">Quantidade</label>
							<f:errors path="itensPedidoCompra[${status.index}].quantidade" cssClass="helper-text" />
						</div>
						
						<div class="input-field col s3">
							<f:input readonly="true" type="number" path="itensPedidoCompra[${status.index}].valor" cssClass="validate" />
							<label class="active" for="itensPedidoCompra[${status.index}].valor">Valor Unitário</label>
							<f:errors path="itensPedidoCompra[${status.index}].valor" cssClass="helper-text" />
						</div>
						
						<div class="input-field col s2">
							<button class="btn-small red deletaItem" title="excluir" type="button" value="${status.index}">
								<i class="material-icons">delete</i>
							</button>
						</div>
					</div>													
				</div>
			</div>
			
		</c:forEach>
	</div>
</f:form>