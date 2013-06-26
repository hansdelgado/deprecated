<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:text name="gch.modificar.programa" var="modificar_programa" />
<gch:base titulo="${modificar_programa}">
    <div class="informacion">
        <span><s:property value="mensaje" /></span><br><br>
        <s:fielderror/>
    </div>
    <s:form action="actualizarPrograma" method="post">
        <fieldset>
            <legend><s:text name="gch.sistema" /></legend>
            <div>
                <s:label key="gch.codigo" />
                <s:textfield name="programa.codigo" maxlength="8" readonly="readonly"  />
            </div>
        </fieldset>
        <fieldset>
            <legend><s:text name="gch.datos.del.programa"/></legend>
            <div>
                <s:label key="gch.titulo"/>
                <s:textfield  name="programa.titulo" maxlength="50"  autofocus="" cssClass="ancho" />
            </div>
            <div>
                <s:label key="gch.descripcion" />
                <s:textfield  name="programa.descripcion" maxlength="50" cssClass="ancho" />
            </div>
            <div>
                <s:label key="gch.objetivos"/>
                <s:textfield name="programa.objetivos"  maxlength="50" cssClass="ancho"/>
            </div>
            <div>
                <s:label key="gch.requisitos"/>
                <s:textfield name="programa.requisitos" maxlength="400" cssClass="ancho" />
            </div>
            <div>
                <s:label key="gch.moneda"/>
                <s:select name="programa.moneda" headerKey="-1" headerValue="%{getText('gch.seleccione')}" list="monedas" value="programa.moneda"  />
            </div>
            <div>
                <s:label key="gch.precio"/>
                <s:textfield name="programa.precio"  maxlength="400" />
            </div>
            <div>
                <s:label key="gch.duracion"/>
                <s:textfield name="programa.duracion" maxlength="400" />
            </div>
            <div>
                <s:label key="gch.fecha"/>
                <s:textfield type="date" name="programa.fechaInicial"   />
            </div>
        </fieldset>
        <button><s:text name="gch.actualizar"/></button>
    </s:form>
</gch:base>
