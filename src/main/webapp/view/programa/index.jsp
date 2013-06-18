<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Programas">
    <div class="informacion">
        <span>${mensaje}</span><br><br>
        <c:if test="${not empty requestScope.errores}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error}</li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>
    <form method="post" action="buscarProgramas">
        <fieldset>
            <legend>Datos de B&uacute;squeda</legend>
            <div>
                <label for="titulo">
                    Titulo
                </label>
                <input type="search" name="titulo" id="titulo" value="${titulo}" maxlength="50" />
            </div>
            <div>
                <label for="descripcion">
                    Descripci&oacute;n
                </label>
                <input type="search" name="descripcion" id="descripcion" value="${descripcion}" maxlength="50" />
            </div>
            <div>
                <label for="tipoBusqueda">
                    Tipo Busqueda
                </label>
                <select name="tipoBusqueda">
                    <option value="0" <c:if test="${tipoBusqueda == 0}">selected</c:if> >Completa</option>
                    <option value="1" <c:if test="${tipoBusqueda == 1}">selected</c:if> >Parcial</option>
                    </select>
                </div>            
            </fieldset>
            <button><span>Buscar</span></button>
        </form>
        <div>
            <nav>
                <ul>
                    <li>
                        <a href="irRegistroPrograma">
                            Registrar nuevo programa
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div>
            <ul id="resultadoConsulta">
                <li class="cabeceraConsulta">
                    <span>Codigo</span>
                    <span>Titulo</span>
                    <span>Descripcion</span>
                    <span>Editar</span>
                    <span>Eliminar</span>
                </li>

            <s:iterator var="programa" value="programas" >
                <li>
                    <span><s:property value="codigo"></s:property></span>
                    <span><s:property value="titulo"></s:property></span>
                    <span><s:property value="descripcion"></s:property></span>

                    <s:url  action="irActualizaPrograma.action" var="urlEditar" >
                        <s:param name="codigo"><s:property value="codigo"></s:property></s:param>
                    </s:url>
                    <span><s:a href="%{urlEditar}" >Editar</s:a></span>
                    
                    <s:url  action="irEliminarPrograma.action" var="urlEliminar" >
                     <s:param name="codigo"><s:property value="codigo"></s:property></s:param>
                    </s:url>
                    <span><s:a href="%{urlEliminar}" style="cursor: pointer" >Borrar</s:a></span>
                </li>
            </s:iterator>        
        </ul>
    </div>
    <script type="text/javascript">
            function confirmarEliminacion(codigo) {

                var mensaje = "¿Desea realmente eliminar este programa?";
                var url = "irEliminarPrograma?codigo=" + codigo;

                if (confirm(mensaje)) {
                    open(url);
                }
                return false;
            }
    </script>
</gch:base>
