<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Programa">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="registrarPrograma" method="post">
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8" required autofocus >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Programa</legend>
            <div>
                <label for="titulo">Titulo</label>
                <input type="text" id="titulo" name="titulo" required maxlength="50" />
            </div>
            <div>
                <label for="descripcion">Descripci&oacute;n</label>
                <input type="text" id="descripcion" name="descripcion" required maxlength="50" />
            </div>
            <div>
                <label for="objetivos">Objetivos</label>
                <input type="text" id="objetivos" name="objetivos" maxlength="50" />
            </div>
            <div>
                <label for="requisitos">Requisitos</label>
                <input type="text" id="requisitos" name="requisitos" required maxlength="400" />
            </div>
            <div>
                <label for="moneda">Moneda</label>
                <select name="moneda">
                    <option value="">----Seleccione----</option>
                    <option value="NS">Nuevo Soles</option>
                    <option value="D">Dolares</option>
                </select>
                
             </div>
             <div>
                <label for="precio">Precio</label>
                <input type="text" id="precio" name="precio" required maxlength="400" />
            </div>
             <div>
                 <label for="duracion">Duraci&oacute;n del Programa</label>
                <input type="text" id="duracion" name="duracion" required maxlength="400" />
            </div>
             <div>
                <label for="precio">Fecha de Inicio</label>
                <input type="date" id="fecha" name="fecha" required maxlength="400" />
            </div>

            
       </fieldset>

        <button>Registrar</button>
    </form>
</gch:base>