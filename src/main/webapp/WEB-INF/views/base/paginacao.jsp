<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:if test="${produtos.hasContent()}">   
		<div class="row">
			<div class="col s12">
		        <ul class="pagination">
		            <li class="${produtos.hasPrevious() ? '' : 'disabled'}">
		            	<c:if test="${produtos.hasPrevious()}">
	            			<a href="?busca=${busca}&pagina=${produtos.getNumber()}"><i class="material-icons">chevron_left</i></a>
		            	</c:if>
		            	<c:if test="${!produtos.hasPrevious()}">
		            		<a href="#"><i class="material-icons">chevron_left</i></a>
		            	</c:if>
		            </li>
		            
		            <c:forEach var="cont" begin="0" end="${produtos.getTotalPages()-1}"    >
			            <li class="${cont==produtos.getNumber() ? 'active' : ''}">
			            	<a href="?busca=${busca}&pagina=${cont+1}">${cont+1}</a>
			            </li>
		            </c:forEach>
		            
		            <li class="${produtos.hasNext() ? '' : 'disabled'}" >
		            	<c:if test="${produtos.hasNext()}">
		            		<a href="?busca=${busca}&pagina=${produtos.getNumber()+2}" rel="next"><i class="material-icons">chevron_right</i></a>
		            	</c:if>				            	
		            	<c:if test="${!produtos.hasNext()}">
		            		<a href="#" rel="next"><i class="material-icons">chevron_right</i></a>
		            	</c:if>
		            </li>
		        </ul>				
			</div>
		</div>
	</c:if>

