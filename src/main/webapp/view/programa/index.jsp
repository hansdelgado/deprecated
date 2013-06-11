<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Programas">
    <div class="informacion">
        <span>${mensaje}</span>
        <c:if test="${not empty requestScope.errores}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error}</li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>
    <form action="buscarProgramas">
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
                <script type="text/javascript">
                    function confirmarEliminacion(codigo) {
                        if (!confirm("¿Desea realmente eliminar este programa?")) {
                            return false;
                        }
                        else {
                            open("irEliminarPrograma?codigo="+codigo);
                            return false;
                        }
                    }
                </script>
            <c:forEach var="programa" items="${requestScope.programa}" >
                <li>
                    <span>${programa.codigo}</span>
                    <span>${programa.titulo}</span>
                    <span>${programa.descripcion}</span>
                    <span><a href="irActualizaPrograma?codigo=${programa.codigo}">Editar</a></span>
                    <span><a onclick="confirmarEliminacion(${programa.codigo})" >Borrar</a></span>
                </li>
            </c:forEach>
        </ul>
    </div>
</gch:base>
