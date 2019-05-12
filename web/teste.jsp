<%@page import="modelo.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <title>Incrição de Aluno</title>
    </head>
    <body>        
        <div class="container">
            <% 
                String nome = request.getAttribute("nome").toString();
                String curso = request.getAttribute("curso").toString();
                String disciplina = request.getAttribute("disciplina").toString();
                String nota = request.getAttribute("nota").toString();
            %>
            <h1 class="pb-2 mt-4 mb-2 border-bottom">Novo aluno</h1>
            <div class="row">
                <div class="col-6">
                    <h5>Nome:</h5>
                    <h5>Curso:</h5>
                    <h5>Disciplina:</h5>
                    <h5>Nota:</h5>            
                </div>
                <div class="col-6">
                    <h5><% out.print(nome); %></h5>
                    <h5><% out.print(curso); %></h5>
                    <h5><% out.print(disciplina); %></h5>
                    <h5><% out.print(nota); %></h5>            
                </div>
            </div>            
                
        </div>        
    </body>
</html>
