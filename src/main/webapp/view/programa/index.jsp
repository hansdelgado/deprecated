<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Programas">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="buscarProgramas">
        <fieldset>
            <legend>Datos de B&uacute;squeda</legend>
            <div>
                <label for="titulo">
                    Titulo
                </label>
                <input type="search" name="titulo" id="titulo" maxlength="50" />
            </div>
             <div>
                <label for="descripcion">
                    Descripci&oacute;n
                </label>
                <input type="search" name="descripcion" id="descripcion" maxlength="50" />
            </div>
            <div>
                <label for="tipoBusqueda">
                    Tipo Busqueda
                </label>
                <select name="tipoBusqueda">
                    <option value="0">Completa</option>
                    <option value="1">Parcial</option>
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
            </li>
            <c:forEach var="programa" items="${requestScope.programa}" >
                <li>
                    <span>${programa.codigo}</span>
                    <span>${programa.titulo}</span>
                    <span>${programa.descripcion}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
</gch:base>