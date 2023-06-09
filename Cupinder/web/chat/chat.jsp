<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chats</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/chat.css" />
    </head>
    <body>
        <jsp:include page="../HEADER/header.jsp"/>

        <div class="container-fluid py-5 px-4" style="background-color: #f8edeb; min-height:70vh">

            <div class="row rounded overflow-hidden justify-content-center">
                <!-- Users box-->
                <div class="col-3 px-0" style=" border-right:10px solid #f8edeb;">
                    <div class="bg-white h-100">

                        <div class="bg-gray px-4 py-2 bg-light">
                            <p class="h5 mb-0 py-1">Chats</p>
                        </div>

                        <div class="messages-box">
                            <div class="list-group rounded-0">

                                <s:iterator value="usuariosConChat" var="usuario">
                                    <s:url id="url" action="mostrarMensajesChat">
                                        <s:param name="destinatarioId" value="#usuario.id"></s:param>
                                    </s:url>
                                    <s:if test="%{#session.destinatarioId == #usuario.id}">
                                        <s:a href="%{url}" cssClass="list-group-item list-group-item-action list-group-item-light rounded-0 selected">
                                            <div class="media row" style="width: 40vh"><img src="${pageContext.request.contextPath}<s:property value="#usuario.fotoPerfil"></s:property>" alt="user" height="70" class="rounded-circle col-3">
                                                    <div class="media-body ml-4 col align-self-center">
                                                        <div class="d-flex align-items-center justify-content-between mb-1">
                                                            <h6 class="mb-0 fs-3"><s:property value="#usuario.usuario"></s:property><s:if test="%{#usuario.dni != null}">     <span><i class="fa-solid fa-circle-check fa-2xs"></i></span></s:if></h6>
                                                        </div>
                                                    </div>
                                                </div>
                                        </s:a>
                                    </s:if>
                                    <s:else>
                                        <s:a href="%{url}" cssClass="list-group-item list-group-item-action list-group-item-light rounded-0">
                                            <div class="media row" style="width: 40vh"><img src="${pageContext.request.contextPath}<s:property value="#usuario.fotoPerfil"></s:property>" alt="user" height="70" class="rounded-circle col-3">
                                                    <div class="media-body ml-4 col align-self-center">
                                                        <div class="d-flex align-items-center justify-content-between mb-1">
                                                            <h6 class="mb-0 fs-3"><s:property value="#usuario.usuario"></s:property><s:if test="%{#usuario.dni != null}">     <span><i class="fa-solid fa-circle-check fa-2xs"></i></span></s:if></h6>
                                                        </div>
                                                    </div>
                                                </div>
                                        </s:a>
                                    </s:else>
                                </s:iterator>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Chat Box-->
                <div class="col-4 px-0"style=" border-left:10px solid #f8edeb;">
                    <s:if test="%{destin != null}"><div class="w-100 text-center bg-light p-2"><h5>Chatea con <b><s:property value="destin.nombre"></s:property> <s:property value="destin.apellidos"></s:property></b></h5></div></s:if>

                            <div class="px-4 py-5 chat-box bg-white">
                        <s:iterator value="mensajesChat" var="mensaje">
                            <!-- Sender Message-->


                            <s:if test="#session.user.id == #mensaje.usuariosByRemitenteId.id">
                                <div class="media w-50 ms-auto mb-3"><img src="${pageContext.request.contextPath}${session.user.fotoPerfil}" alt="user" width="50" class="rounded-circle">
                                    <div class="media-body ml-3">
                                        <div class=" rounded py-2 px-3 mb-2" style="background-color: #f8edeb">
                                            <p class="text-small mb-0 text-muted"><s:property value="#mensaje.texto"></s:property></p>
                                            </div>
                                            <p class="small text-muted"><s:property value="#mensaje.fechaEnvio"></s:property></p>
                                        </div>
                                    </div>
                            </s:if>
                            <s:else>
                                <div class="media w-50 mb-3"><img src="${pageContext.request.contextPath}${usuarioDestinatario.fotoPerfil}" alt="user" width="50" class="rounded-circle">
                                    <div class="media-body ml-3">
                                        <div class="bg-light rounded py-2 px-3 mb-2">
                                            <p class="text-small mb-0 text-muted"><s:property value="#mensaje.texto"></s:property></p>
                                            </div>
                                            <p class="small text-muted"><s:property value="#mensaje.fechaEnvio"></s:property></p>
                                        </div>
                                    </div>
                            </s:else>




                        </s:iterator>


                        <!-- Typing area -->


                    </div>
                    <s:form id="enviarMensaje" action="enviarMensaje" theme="simple">
                        <div class="input-group">
                            <s:if test="%{destin == null}"> <s:textfield name="mensajito" value="" placeholder="Escriba un mensaje..." cssClass="form-control rounded-0 border-0 py-3 bg-light" disabled="true"/> 
                                <div class="input-group-append bg-light"  style=" background-color: white">
                                    <button type="submit" class="btn btn-link" disabled="true">
                                        <i class="fa-solid fa-paper-plane fs-3 pt-1" style="color: #e8a598"></i>
                                    </button>
                                </div></s:if>
                            <s:else><s:textfield name="mensajito" value="" placeholder="Escriba un mensaje..." cssClass="form-control rounded-0 border-0 py-3 bg-light" />
                                <div class="input-group-append bg-light"  style=" background-color: white">
                                    <button type="submit" class="btn btn-link">
                                        <i class="fa-solid fa-paper-plane fs-3 pt-1" style="color: #e8a598"></i>
                                    </button>
                                </div></s:else>


                            </div>
                    </s:form>
                </div>

            </div>

        </div>
        <jsp:include page="../FOOTER/footer.jsp"/>
    </body>
    <style>
        .list-group-item.selected {
            background-color: #fec5bb;
            color:black;
        }
    </style>
</html>
