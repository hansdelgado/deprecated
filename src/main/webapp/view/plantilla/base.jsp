<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <tiles:insertAttribute name="gch.view.plantilla.encabezado"/>
    </head>
    <body>
        <tiles:insertAttribute name="gch.view.plantilla.menu"/>
        <tiles:insertAttribute name="gch.view.plantilla.ayuda"/>
        <section id="contenido">
            <div>
                <tiles:insertAttribute name="gch.view.plantilla.cuerpo" />
            </div>
        </section>
        <tiles:insertAttribute name="gch.view.plantilla.pie"/>
    </body>
</html>

