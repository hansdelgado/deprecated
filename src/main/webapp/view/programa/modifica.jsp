<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Modificar Información de Programa">
    <div class="informacion">
        <span>${mensaje}</span><br>
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
                <input type="text" id="codigo" name="codigo" maxlength="8" value="${codigo}"  readonly  >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Programa</legend>
            <div>
                <label for="titulo">Titulo</label>
                <input type="text" id="titulo" name="titulo" value="${titulo}" maxlength="50"  autofocus="" class="ancho" />
            </div>
            <div>
                <label for="descripcion">Descripci&oacute;n</label>
                <input type="text" id="descripcion" name="descripcion" value="${descripcion}" maxlength="50" class="ancho"/>
            </div>
            <div>
                <label for="objetivos">Objetivos</label>
                <input type="text" id="objetivos" name="objetivos" value="${objetivos}" maxlength="50"class="ancho"/>
            </div>
            <div>
                <label for="requisitos">Requisitos</label>
                <input type="text" id="requisitos" name="requisitos" value="${requisitos}"  maxlength="400" class="ancho" />
            </div>
            <div>
                <label for="moneda">Tipo de Moneda</label>
                <select name="moneda">
                    <option value="" <c:if test="${moneda == ''}">selected</c:if> >----Seleccione----</option>
                    <option value="NS" <c:if test="${moneda == 'NS'}">selected</c:if> >Nuevo Soles</option>
                    <option value="D" <c:if test="${moneda == 'D'}">selected</c:if> >Dolares</option>
                    </select>
                </div>
                <div>
                    <label for="precio">Precio</label>
                    <input type="text" id="precio" name="precio" value="${precio}" maxlength="400" />
            </div>
            <div>
                <label for="duracion">Duraci&oacute;n del Programa</label>
                <input type="text" id="duracion" name="duracion" value="${duracion}" maxlength="400" />
            </div>
            <div>
                <label for="precio">Fecha de Inicio</label>
                <input type="date" id="fecha" name="fecha" value="${fecha}" maxlength="400" />
            </div>
        </fieldset>
        <button>Actualizar</button>
    </form>
</gch:base>
