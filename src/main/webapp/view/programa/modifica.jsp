<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Modificar Información de Programa">
    <div class="informacion">
        <span>${mensaje}</span>
        <c:if test="${not empty requestScope.errores}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </c:if>
    </div>
    <form action="actualizarPrograma" method="post">
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8" value="${programa.codigo}" autofocus disabled>
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Programa</legend>
            <div>
                <label for="titulo">Titulo</label>
                <input type="text" id="titulo" name="titulo" value="${programa.titulo}" maxlength="50"  />
            </div>
            <div>
                <label for="descripcion">Descripci&oacute;n</label>
                <input type="text" id="descripcion" name="descripcion" value="${programa.descripcion}" maxlength="50" />
            </div>
            <div>
                <label for="objetivos">Objetivos</label>
                <input type="text" id="objetivos" name="objetivos" value="${programa.objetivos}" maxlength="50" />
            </div>
            <div>
                <label for="requisitos">Requisitos</label>
                <input type="text" id="requisitos" name="requisitos" value="${programa.requisitos}"  maxlength="400" />
            </div>
            <div>
                <label for="moneda">Tipo de Moneda</label>
                <input type="text" id="moneda" name="moneda" value="${programa.moneda}" maxlength="400" disabled/>
            </div>
            <div>
                <label for="precio">Precio</label>
                <input type="text" id="precio" name="precio" value="${programa.precio}" maxlength="400" disabled/>
            </div>
            <div>
                <label for="duracion">Duraci&oacute;n del Programa</label>
                <input type="text" id="duracion" name="duracion" value="${programa.duracion}" maxlength="400" disabled />
            </div>
            <div>
                <label for="precio">Fecha de Inicio</label>
                <input type="date" id="fecha" name="fecha" value="${programa.fecha}" maxlength="400" disabled/>
            </div>
        </fieldset>
        <button>Actualizar</button>
    </form>
</gch:base>
