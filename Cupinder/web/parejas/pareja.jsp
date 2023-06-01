<%-- 
    Document   : pareja
    Created on : 01-jun-2023, 2:46:29
    Author     : alervgr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script src="./JS/goUpButton.js"></script>
    </head>
    <body>
        <jsp:include page="../HEADER/header.jsp" />
        <div class="container-fluid pt-3 pb-3" style="background-color: #f8edeb; min-height: 79vh">
            <div class="container pb-5">
                <div class="row pb-5">
                    <s:iterator value="listaUsuariosC" var="usuario">
                        <div class="col-lg-4">
                            <div class="card p-0 w-100 m-2">
                                <div class="card-image h-100">
                                    <img src="${pageContext.request.contextPath}<s:property value="#usuario.fotoPerfil"></s:property>"
                                         alt="" class="h-100">
                                </div>
                                <div class="card-content d-flex flex-column align-items-center">
                                    <h4 class="pt-2"><s:property value="#usuario.nombre"></s:property></h4>
                                    <h5><s:property value="#usuario.ocupacion"></s:property>, <s:property value="#usuario.edad"></s:property> años.</h5>

                                    <ul class="social-icons d-flex justify-content-center">
                                        <li>
                                                <a href="<s:url action="obsPerfil"></s:url>">
                                                <span><i class="fa-sharp fa-solid fa-eye" style="color: #f2f2f2;"></i></span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="<s:url action="obsPerfil"></s:url>">
                                        <span><i class="fa-sharp fa-regular fa-heart" style="color: #b30000;" onclick=""></i></span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </s:iterator>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../FOOTER/footer.jsp" />

    <!-- BOTÓN SCROLL TO TOP -->
    <button onclick="scrollToTop()" id="goUpButton" class="btn position-fixed" title="Ir arriba">
        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-arrow-up"
             viewBox="0 0 16 16" alt="Flecha hacia arriba">
        <path fill-rule="evenodd"
              d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z" />
        </svg>
    </button>

</body>
</html>