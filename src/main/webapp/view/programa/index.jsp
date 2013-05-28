<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Programas">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="listarProgramas">
        <fieldset>
            <legend>Datos de B&uacute;squeda</legend>
            <div>
                <label for="nombre">
                    Nombre
                </label>
                <input type="search" name="nombre" id="nombre" maxlength="50" />
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
                <span>Nombre</span>
            </li>
            <c:forEach var="programa" items="${requestScope.programas}" >
                <li>
                    <span>${programa.codigo}</span>
                    <span>${programa.nombre}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
</gch:base>