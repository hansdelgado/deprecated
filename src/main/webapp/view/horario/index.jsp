<%@taglib prefix="s" uri="/struts-tags"%>
<h1>Listado de Horarios</h1>
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <s:form action="buscarHorarios">
        <fieldset>
            <legend><s:text name="titulo.busqueda" /></legend>
                <s:textfield key="form.descripcion" name="horario.descripcion" />
        </fieldset>
        <fieldset>
            <div>
                <s:select key="form.tipoBusqueda" list="%{#session.tiposBusqueda}" required="true" name="tipoBusquedaSeleccionado" />
            </div>
        </fieldset>
                <s:submit key="form.buscar" />
    </s:form>
    <div>
        <nav>
            <ul>
                <li>
                    <s:url action="agregarHorario" id="newHorario" />
                    <s:a href="%{newHorario}"><s:text name="agregar.horario" /></s:a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <ul id="resultadoConsulta">
            <li class="cabeceraConsulta">
                <span><s:text name="form.codigo" /></span>
                <span><s:text name="form.descripcion" /></span>
                <span><s:text name="form.momentoInicio" /></span>
                <span><s:text name="form.momentoFin" /></span>
                <span><s:text name="form.estado" /></span>
            </li>
            <s:iterator value="horarios" var="horario">
                <li>
                    <span><s:property value="codigo"/></span>
                    <span><s:property value="descripcion"/></span>
                    <span><s:property value="momentoInicio"/></span>
                    <span><s:property value="momentoFin"/></span>
                    <span><s:property value="estado"/></span>
                    <span>
                        <s:url action="editarHorario" id="editHorario">
                            <s:param name="horario.codigo"><s:property value="codigo"/></s:param>
                        </s:url>
                        <s:a href="%{editHorario}"><s:text name="editar.horario" /></s:a>
                    </span>
                    <span>
                        <s:url action="eliminarHorario" id="deleteHorario">
                            <s:param name="horario.codigo"><s:property value="codigo"/></s:param>
                        </s:url>
                        <s:a href="%{deleteHorario}"><s:text name="eliminar.horario" /></s:a>
                    </span>
                </li>
            </s:iterator>
        </ul>
    </div>