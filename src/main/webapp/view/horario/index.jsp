<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags"%>
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
                    <s:url action="irRegistroHorario" id="newHorario" />
                    <s:a href="%{newHorario}">Registrar nuevo horario</s:a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <ul id="resultadoConsulta">
            <li class="cabeceraConsulta">
                <span>Codigo</span>
                <span>Descripción</span>
                <span>Inicio</span>
                <span>Fin</span>
                <span>Estado</span>
            </li>
            <s:iterator value="horarios" var="horario">
                <li>
                    <span>${horario.codigo}</span>
                    <span>${horario.descripcion}</span>
                    <span>${horario.momentoInicio}</span>
                    <span>${horario.momentoFin}</span>
                    <span>${horario.estado}</span>
                    <span><a href="irModificarHorario?codigo=<c:out value="${horario.codigo}"/>">Modificar</a></span>
                    <span><a href="eliminarHorario?codigo=<c:out value="${horario.codigo}"/>">Eliminar</a></span>
                </li>
            </s:iterator>
        </ul>
    </div>
</gch:base>