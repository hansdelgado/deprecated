<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<gch:base titulo="Listado de Horarios">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <s:form action="buscarHorarios">
        <fieldset>
            <legend>Datos de búsqueda</legend>
                <s:textfield label="Descripción" name="horario.descripcion" />
        </fieldset>
        <fieldset>
            <div>
                <s:select label="Tipo de búsqueda" list="tiposBusqueda" required="true" name="tipoBusquedaSeleccionado" />
            </div>
        </fieldset>
        <s:submit value="Buscar" />
    </s:form>
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
                    <span><s:property value="codigo"/></span>
                    <span><s:property value="descripcion"/></span>
                    <span><s:property value="momentoInicio"/></span>
                    <span><s:property value="momentoFin"/></span>
                    <span><s:property value="estado"/></span>
                    <span><a href="irModificarHorario?codigo=<c:out value="${horario.codigo}"/>">Modificar</a></span>
                    <span><a href="eliminarHorario?codigo=<c:out value="${horario.codigo}"/>">Eliminar</a></span>
                </li>
            </s:iterator>
        </ul>
    </div>
</gch:base>