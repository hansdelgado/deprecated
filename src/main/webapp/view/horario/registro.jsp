<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<gch:base titulo="Registro de Horarios">

    <s:form action="guardarHorario">
        <fieldset>
            <legend><s:text name="form.datos"/></legend>
            <s:div>
                <s:if test="horario==null">
                    <s:textfield key="form.codigo" name="horario.codigo" maxLength="3" required="true" />
                </s:if>
                <s:else>
                    <s:textfield key="form.codigo" name="horario.codigo" readonly="true" />
                </s:else>
            </s:div>
            <s:div>
                <s:textfield key="form.descripcion" name="horario.descripcion" required="true" maxLength="20" />
            </s:div>
            <s:div>
                <s:textfield key="form.momentoInicio" name="horario.momentoInicio" required="true" maxLength="2" />
            </s:div>
            <s:div>
                <s:textfield key="form.momentoFin" name="horario.momentoFin" required="true" maxLength="2" />
            </s:div>
            <s:div>
                <s:select key="form.estado" list="%{#session.estados}" required="true" headerKey="" headerValue="-- Seleccione --" name="horarioSeleccionado" />
            </s:div>
        </fieldset>
                <s:submit key="form.guardar" />
    </s:form>
</gch:base>