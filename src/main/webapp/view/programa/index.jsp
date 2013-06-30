<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<h1>
    <s:text name='gch.programa.listado'/>
</h1>

<div class="informacion">
    <span><s:property value="mensaje" /></span><br><br>
    <s:fielderror/>
</div>
<s:form namespace="/programa" action="buscar" method="post">
    <fieldset>
        <legend><s:text name="gch.app.datos.de.busqueda"/></legend>
        <div>
            <s:label key="gch.programa.titulo" />
            <s:textfield name="titulo" maxlength="50" />
        </div>
        <div>
            <s:label key="gch.programa.descripcion" />
            <s:textfield name="descripcion" maxlength="50" />
        </div>
        <div>
            <s:label key="gch.programa.busqueda.tipo"/>
            <select name="tipoBusqueda">
                <option value="0" <c:if test="${tipoBusqueda == 0}">selected</c:if> ><s:text name="gch.programa.busqueda.completa"/></option>
                <option value="1" <c:if test="${tipoBusqueda == 1}">selected</c:if> ><s:text name="gch.programa.busqueda.parcial"/></option>
                </select>
            </div>            
        </fieldset>
        <button><span><s:text name="gch.programa.buscar"/></span></button>
</s:form>
<div>
    <nav>
        <ul>
            <li>
                <s:a namespace="/programa" action="nuevo">
                    <s:text name="gch.programa.nuevo"/>
                </s:a>
            </li>
        </ul>
    </nav>
</div>
<div>
    <ul id="resultadoConsulta">
        <li class="cabeceraConsulta">
            <span><s:text name="gch.programa.codigo"/></span>
            <span><s:text name="gch.programa.titulo"/></span>
            <span><s:text name="gch.programa.descripcion"/></span>
            <span><s:text name="gch.programa.editar"/></span>
            <span><s:text name="gch.programa.eliminar"/></span>
        </li>

        <s:iterator var="programa" value="programas" >
            <li>
                <span><s:property value="codigo"></s:property></span>
                <span><s:property value="titulo"></s:property></span>
                <span><s:property value="descripcion"></s:property></span>

                <s:url namespace="/programa" action="editar" var="urlEditar" >
                    <s:param name="codigo" value="%{codigo}" />
                </s:url>
                <span><s:a href="%{urlEditar}" > <s:text name="gch.programa.editar"/></s:a></span>

                <s:url namespace="/programa" action="eliminar" var="urlEliminar" >
                    <s:param name="codigo" value="%{codigo}" />
                </s:url>
                <s:text name="gch.programa.pregunta.eliminar" var="confirmar_msg" />
                <span>
                    <s:a href="%{urlEliminar}" onclick="if(!confirm('%{confirmar_msg}')){return false;}" style="cursor: pointer" >
                        <s:text name="gch.programa.eliminar"/>
                    </s:a>
                </span>
            </li>
        </s:iterator>        
    </ul>
</div>

