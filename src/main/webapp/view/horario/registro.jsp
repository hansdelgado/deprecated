<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<gch:base titulo="Registro de Horarios">
    <div class="informacion">
        <span>${mensaje}</span>
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <c:if test="${not empty requestScope.errores}">
                <ul>
                    <c:forEach var="error" items="${requestScope.errores}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>
    <s:form action="registrarHorario">
        <fieldset>
            <legend>Datos</legend>
            <s:div>
                <s:textfield label="Código" name="horario.codigo" maxLength="3" required="true" />
            </s:div>
            <s:div>
                <s:textfield label="Descripción" name="horario.descripcion" required="true" maxLength="20" />
            </s:div>
            <s:div>
                <s:textfield label="Momento de inicio" name="horario.momentoInicio" required="true" maxLength="2" />
            </s:div>
            <s:div>
                <s:textfield label="Momento de fin" name="horario.momentoFin" required="true" maxLength="2" />
            </s:div>
            <s:div>
                <s:select label="Estado" list="estados" required="true" headerKey="-1" headerValue="-- Seleccione --" name="horarioSeleccionado" />
            </s:div>            
        </fieldset>
                <s:submit value="Registrar" />
    </s:form>
</gch:base>