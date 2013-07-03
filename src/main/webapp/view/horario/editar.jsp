<%@taglib prefix="s" uri="/struts-tags"%>
    <h1><s:text name="horario.titulo.modificar" /></h1>
    <s:form action="updateHorario">
        <fieldset>
            <legend><s:text name="form.datos"/></legend>
            <s:div>
                <s:textfield key="form.codigo" name="horario.codigo" readonly="true" />
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
                <s:submit value="%{getText('form.guardar')}" />
    </s:form>