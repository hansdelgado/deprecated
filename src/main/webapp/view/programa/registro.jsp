<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:text name='gch.registro.programa' var="registro_programa"/>
<gch:base titulo="${registro_programa}">
    <div class="informacion">   
        <s:fielderror/>
    </div>
    <button onclick="cargarDatos()"><s:text name="gch.simular.carga"/></button>
    <s:form action="registrarPrograma" method="post">
        <fieldset>
            <legend><s:text name="gch.sistema" /></legend>
            <div>
                <s:label key="gch.codigo"/>
                <s:textfield  name="programa.codigo"  maxlength="8" autofocus="autofocus" />
            </div>
        </fieldset>
        <fieldset>
            <legend><s:text name="gch.datos.del.programa"/></legend>
            <div>
                <s:label key="gch.titulo"/>
                <s:textfield  name="programa.titulo" maxlength="50" cssClass="ancho" />
            </div>
            <div>
                <s:label key="gch.descripcion"/>
                <s:textfield  name="programa.descripcion" maxlength="50" cssClass="ancho" />
            </div>
            <div>
                <s:label key="gch.objetivos"/>
                <s:textfield name="programa.objetivos" maxlength="50"  cssClass="ancho"/>
            </div>
            <div>
                <s:label key="gch.requisitos"/>
                <s:textfield  name="programa.requisitos"  maxlength="400" cssClass="ancho" />
            </div>
            <div>
                <s:label key="gch.moneda"/>
                <s:select name="programa.moneda" headerKey="-1" headerValue="%{getText('gch.seleccione')}" list="monedas"  />
            </div>
            <div>
                <s:label key="gch.precio"/>
                <s:textfield name="programa.precio" maxlength="400" />
            </div>
            <div>
                <s:label key="gch.duracion"/>
                <s:textfield name="programa.duracion"  maxlength="400" />
            </div>
            <div>
                <s:label key="gch.fecha"/>
                <s:textfield type="date"  name="programa.fechaInicial" />
            </div>
        </fieldset>
        <button><s:text name="gch.registrar" /></button>
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
</gch:base>
