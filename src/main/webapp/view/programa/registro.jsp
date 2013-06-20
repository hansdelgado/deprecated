<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<gch:base titulo="Registro de Programa">
    <div class="informacion">   
         <s:fielderror/>
    </div>
    <button onclick="cargarDatos()">Simular Carga</button>
    <form action="registrarPrograma" method="post">
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="programa.codigo" value="<s:property value="programa.codigo"/>" maxlength="8" autofocus="autofocus" />
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Programa</legend>
            <div>
                <label for="titulo">Titulo</label>
                <input type="text"  id="titulo" name="programa.titulo" value="<s:property value="programa.titulo"/>" maxlength="50" class="ancho" />
            </div>
            <div>
                <label for="descripcion">Descripci&oacute;n</label>
                <input type="text"  id="descripcion" name="programa.descripcion" value="<s:property value="programa.descripcion"/>" maxlength="50" class="ancho" />
            </div>
            <div>
                <label for="objetivos">Objetivos</label>
                <input type="text" id="objetivos" name="programa.objetivos" value="<s:property value="programa.objetivos"/>"  maxlength="50"  class="ancho"/>
            </div>
            <div>
                <label for="requisitos">Requisitos</label>
                <input type="text" id="requisitos" name="programa.requisitos" value="<s:property value="programa.requisitos"/>"  maxlength="400" class="ancho" />
            </div>
            <div>
                <label for="moneda">Moneda</label>
                <select name="programa.moneda">
                    <option value="" <c:if test="${moneda == ''}">selected</c:if> >----Seleccione----</option>
                    <option value="NS" <c:if test="${moneda == 'NS'}">selected</c:if> >Nuevo Soles</option>
                    <option value="D" <c:if test="${moneda == 'D'}">selected</c:if> >Dolares</option>
                    </select>
                </div>
                <div>
                    <label for="precio">Precio</label>
                    <input type="text" id="precio" name="programa.precio" value="<s:property value="programa.precio"/>"  maxlength="400" />
            </div>
            <div>
                <label for="duracion">Duraci&oacute;n del Programa</label>
                <input type="text" id="duracion" name="programa.duracion" value="<s:property value="programa.duracion"/>"  maxlength="400" />
            </div>
            <div>
                <label for="fechaInicial">Fecha de Inicio</label>
                <input type="date" id="fecha" name="programa.fechaInicial" value="<s:property value="programa.fechaInicial"/>"  />
                
            </div>
        </fieldset>
        <button>Registrar</button>
    </form>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script type="text/javascript">
        function cargarDatos() {
            $("#codigo").val("3");
            $("#titulo").val("TECNICOS INDUSTRIALES");
            $("#descripcion").val("Orientado al sector de manufactura masiva");
            $("#objetivos").val("Conocimiento electronica y electricida");
            $("#requisitos").val("Ninguno");
            $("#precio").val("3700");
            $("#duracion").val("140");
            $("#fecha").val("2013-06-11");
        }
    </script>
</gch:base>
