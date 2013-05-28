<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Horarios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="listarHorarios">
        <fieldset>
            <legend>Hora limite de inicio (horas)</legend>
            <div>
                <label for="luegode">
                    Luego de la(s)
                </label>
                <input type="range" min="6" max="23" name="luegode" id="luegode" maxlength="2" />
            </div>
        </fieldset>
        <fieldset>
            <legend>Hora limite de fin (horas)</legend>
            <div>
                <label for="antesde">
                    Antes de la(s)
                </label>
                <input type="range" min="6" max="23" name="antesde" id="antesde" maxlength="50" />
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