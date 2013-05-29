<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Horarios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="buscarHorarios">
        <fieldset>
            <legend>Datos de búsqueda</legend>
            <div>
                <label for="descripcion">
                    Descripción
                </label>
                <input type="text" name="descripcion" id="descripcion" />
            </div>
        </fieldset>
        <fieldset>
            <div>
                <label for="tipoBusqueda">
                    Tipo Búsqueda
                </label>
                <select name="tipoBusqueda" id="tipoBusqueda">
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
                    <a href="irRegistroHorario">
                        Registrar nuevo horario
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <ul id="resultadoConsulta">
            <li class="cabeceraConsulta">
                <span>Codigo</span>
                <span>Descripcion</span>
            </li>
            <c:forEach var="horario" items="${requestScope.horarios}" >
                <li>
                    <span>${horario.codigo}</span>
                    <span>${horario.descripcion}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
</gch:base>