<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<c:if test="${listaPaginada.hasContent()}">   
		<div class="row">
			<div class="col s12">
		        <ul class="pagination">
		            <li class="${listaPaginada.hasPrevious() ? '' : 'disabled'}">
		            	<c:if test="${listaPaginada.hasPrevious()}">
	            			<a href="?busca=${busca}&pagina=${listaPaginada.getNumber()}"><i class="material-icons">chevron_left</i></a>
		            	</c:if>
		            	<c:if test="${!listaPaginada.hasPrevious()}">
		            		<a href="#"><i class="material-icons">chevron_left</i></a>
		            	</c:if>
		            </li>
		            
		            <c:forEach var="cont" begin="0" end="${listaPaginada.getTotalPages()-1}"    >
			            <li class="${cont==listaPaginada.getNumber() ? 'active' : ''}">
			            	<a href="?busca=${busca}&pagina=${cont+1}">${cont+1}</a>
			            </li>
		            </c:forEach>
		            
		            <li class="${listaPaginada.hasNext() ? '' : 'disabled'}" >
		            	<c:if test="${listaPaginada.hasNext()}">
		            		<a href="?busca=${busca}&pagina=${listaPaginada.getNumber()+2}" rel="next"><i class="material-icons">chevron_right</i></a>
		            	</c:if>				            	
		            	<c:if test="${!listaPaginada.hasNext()}">
		            		<a href="#" rel="next"><i class="material-icons">chevron_right</i></a>
		            	</c:if>
		            </li>
		        </ul>				
			</div>
		</div>
	</c:if>

