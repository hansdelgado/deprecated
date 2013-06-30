<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>
    <s:text name='gch.programa.subtitulo.registro'/>
</h1>

<div class="informacion">
    <span><s:property value="mensaje" /></span><br><br>
    <s:fielderror/>
</div>
<div style="padding-bottom: 5px;">
    <a onclick="cargarDatos()" id="urls"><s:text name="gch.programa.simular.carga"/></a>
</div>
<s:form namespace="/programa" action="registrar" method="post">
    <fieldset>
        <legend><s:text name="gch.app.sistema.solo" /></legend>
        <div>
            <s:label key="gch.programa.codigo"/>
            <s:textfield  name="programa.codigo"  maxlength="8" autofocus="autofocus" />
        </div>
    </fieldset>
    <fieldset>
        <legend><s:text name="gch.programa.datos"/></legend>
        <div>
            <s:label key="gch.programa.titulo"/>
            <s:textfield  name="programa.titulo" maxlength="50" cssClass="ancho" />
        </div>
        <div>
            <s:label key="gch.programa.descripcion"/>
            <s:textfield  name="programa.descripcion" maxlength="50" cssClass="ancho" />
        </div>
        <div>
            <s:label key="gch.programa.objetivos"/>
            <s:textfield name="programa.objetivos" maxlength="50"  cssClass="ancho"/>
        </div>
        <div>
            <s:label key="gch.programa.requisitos"/>
            <s:textfield  name="programa.requisitos"  maxlength="400" cssClass="ancho" />
        </div>
        <div>
            <s:label key="gch.programa.moneda"/>
            <s:select name="programa.moneda" headerKey="" headerValue="%{getText('gch.programa.seleccione')}" list="monedas"  />
        </div>
        <div>
            <s:label key="gch.programa.precio"/>
            <s:textfield name="programa.precio" maxlength="400" />
        </div>
        <div>
            <s:label key="gch.programa.duracion"/>
            <s:textfield name="programa.duracion"  maxlength="400" />
        </div>
        <div>
            <s:label key="gch.programa.fecha"/>
            <s:textfield type="date"  name="programa.fechaInicial" />
        </div>
    </fieldset>
    <button><s:text name="gch.programa.registrar" /></button>
</s:form>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
        function cargarDatos() {
            $("input[name='programa.codigo']").val("3");
            $("input[name='programa.titulo']").val("TECNICOS INDUSTRIALES");
            $("input[name='programa.descripcion']").val("Orientado al sector de manufactura masiva");
            $("input[name='programa.objetivos']").val("Conocimiento electronica y electricida");
            $("input[name='programa.requisitos']").val("Ninguno");
            $("input[name='programa.precio']").val("3700");
            $("input[name='programa.duracion']").val("140");
            $("input[name='programa.fechaInicial']").val("2013-06-11");
        }
</script>

