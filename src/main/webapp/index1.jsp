<%@ include file="WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="WEB-INF/jspf/directive/taglib.jspf" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<c:set var="title" value="Selection committee">
    <%@ include file="WEB-INF/jspf/head.jspf" %>
    <link
    rel="stylesheet"
    href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css"
    integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
    crossorigin=""
    />
    <!-- Make sure you put this AFTER Leaflet's CSS -->
    <script
    src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"
    integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
    crossorigin=""
    ></script>
    <script src="http://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
    <script src="js/leaflet-providers.js"></script>
    </head>
    <body>

    <h1>Selection committee</h1>

    <script>
    var mymap = L.map("mapid").setView([49.844, 24.02], 15);
    L.tileLayer.provider("OpenStreetMap.Mapnik").addTo(mymap);


    </script>

    <div id="mapid" style="height: 180px"></div>
    </body>
    </html>
