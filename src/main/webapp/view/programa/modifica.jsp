<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:text name="gch.programa.subtitulo.modificar" var="modificar_programa" />
<gch:base titulo="${modificar_programa}">
    <div class="informacion">
        <span><s:property value="mensaje" /></span><br><br>
        <s:fielderror/>
    </div>
    <s:form namespace="/programa" action="guardar" method="post">
        <fieldset>
            <legend><s:text name="gch.app.sistema.solo" /></legend>
            <div>
                <s:label key="gch.programa.codigo" />
            <input type="text" name="programa.codigo" value="<s:property value="programa.codigo"/>" maxlength="8" readonly />
            </div>
        </fieldset>
        <fieldset>
            <legend><s:text name="gch.programa.datos"/></legend>
            <div>
                <s:label key="gch.programa.titulo"/>
                <s:textfield  name="programa.titulo" maxlength="50"  autofocus="" cssClass="ancho" />
            </div>
            <div>
                <s:label key="gch.programa.descripcion" />
                <s:textfield  name="programa.descripcion" maxlength="50" cssClass="ancho" />
            </div>
            <div>
                <s:label key="gch.programa.objetivos"/>
                <s:textfield name="programa.objetivos"  maxlength="50" cssClass="ancho"/>
            </div>
            <div>
                <s:label key="gch.programa.requisitos"/>
                <s:textfield name="programa.requisitos" maxlength="400" cssClass="ancho" />
            </div>
            <div>
                <s:label key="gch.programa.moneda"/>
                <s:select name="programa.moneda" headerKey="-1" headerValue="%{getText('gch.programa.seleccione')}" list="monedas" value="programa.moneda"  />
            </div>
            <div>
                <s:label key="gch.programa.precio"/>
                <s:textfield name="programa.precio"  maxlength="400" />
            </div>
            <div>
                <s:label key="gch.programa.duracion"/>
                <s:textfield name="programa.duracion" maxlength="400" />
            </div>
            <div>
                <s:label key="gch.programa.fecha"/>
                <s:textfield type="date" name="programa.fechaInicial"   />
            </div>
        </fieldset>
        <button><s:text name="gch.programa.actualizar"/></button>
    </s:form>
</gch:base>
