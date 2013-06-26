<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:text name='gch.listado.programas' var="listado_programas"/>
<gch:base titulo="${listado_programas}">
    <s:url action="listarProgramas" var="urlEn" >
        <s:param name="request_locale">en</s:param>
    </s:url>
    <s:url action="listarProgramas" var="urlEs" >
        <s:param name="request_locale">es</s:param>
    </s:url>
    <s:a href="%{urlEn}" >English</s:a>
    <s:a href="%{urlEs}" >Español</s:a>
    <div class="informacion">
        <s:fielderror/>
        <span><s:property value="mensaje" /></span><br><br>
        <c:if test="${not empty requestScope.errores}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error}</li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>
    <s:form action="buscarProgramas" method="post">
        <fieldset>
            <legend><s:text name="gch.datos.de.busqueda"/></legend>
            <div>
                <s:label key="gch.titulo" />
                <s:textfield name="titulo" maxlength="50" />
            </div>
            <div>
                <s:label key="gch.descripcion" />
                <s:textfield name="descripcion" maxlength="50" />
            </div>
            <div>
                <s:label key="gch.tipo.busqueda"/>
                <select name="tipoBusqueda">
                    <option value="0" <c:if test="${tipoBusqueda == 0}">selected</c:if> ><s:text name="gch.completa"/></option>
                    <option value="1" <c:if test="${tipoBusqueda == 1}">selected</c:if> ><s:text name="gch.parcial"/></option>
                    </select>
                </div>            
            </fieldset>
            <button><span><s:text name="gch.buscar"/></span></button>
    </s:form>
    <div>
        <nav>
            <ul>
                <li>
                    <s:a action="irRegistroPrograma">
                        <s:text name="gch.registrar.nuevo.programa"/>
                    </s:a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <ul id="resultadoConsulta">
            <li class="cabeceraConsulta">
                <span><s:text name="gch.codigo"/></span>
                <span><s:text name="gch.titulo"/></span>
                <span><s:text name="gch.descripcion"/></span>
                <span><s:text name="gch.editar"/></span>
                <span><s:text name="gch.eliminar"/></span>
            </li>

            <s:iterator var="programa" value="programas" >
                <li>
                    <span><s:property value="codigo"></s:property></span>
                    <span><s:property value="titulo"></s:property></span>
                    <span><s:property value="descripcion"></s:property></span>

                    <s:url action="irActualizaPrograma" var="urlEditar" >
                        <s:param name="codigo"><s:property value="codigo"></s:property></s:param>
                    </s:url>
                    <span><s:a href="%{urlEditar}" ><s:text name="gch.editar"/></s:a></span>

                    <s:url action="irEliminarPrograma" var="urlEliminar" >
                        <s:param name="codigo"><s:property value="codigo"></s:property></s:param>
                    </s:url>
                    <s:text name="gch.confirmar.eliminar" var="confirmar_msg" />
                    <span>
                        <s:a href="%{urlEliminar}" onclick="if(!confirm('%{confirmar_msg}')){return false;}" style="cursor: pointer" >
                            <s:text name="gch.eliminar"/>
                        </s:a>
                    </span>
                    </li>
            </s:iterator>        
        </ul>
    </div>
</gch:base>
