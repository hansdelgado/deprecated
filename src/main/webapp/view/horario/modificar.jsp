<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<gch:base titulo="Modificar horario">

    <s:form action="modificarHorario">
        <fieldset>
            <legend>Datos</legend>
            <s:div>
            <s:textfield label="Código" name="horario.codigo" maxlength="3" readonly="true" />
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
                <s:select label="Estado" list="%{#session.estados}" required="true" headerKey="" headerValue="-- Seleccione --" name="horarioSeleccionado" />
            </s:div>    
        </fieldset>
        <s:submit value="Guardar" />
    </s:form>
</gch:base>