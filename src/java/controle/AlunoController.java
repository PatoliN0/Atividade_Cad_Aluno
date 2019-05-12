package controle;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Banco;

@WebServlet(urlPatterns = "/cadastroAluno")
public class AlunoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        Banco banco = new Banco();
        Aluno a = new Aluno();
        
        a.setNome(request.getParameter("nome"));
        a.setDisciplina(request.getParameter("disciplina"));
        a.setCurso(request.getParameter("curso"));
        String nota = request.getParameter("nota");
        if(nota.equals("")){//Não é uma grande validação
            nota = "0.0";
        }
        a.setNota(Double.parseDouble(nota));
        
        try {
            banco.conectar();
            banco.inserir(a);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/teste.jsp");        
        request.setAttribute("nome", a.getNome());                
        request.setAttribute("curso", a.getCurso());
        request.setAttribute("disciplina", a.getDisciplina());
        request.setAttribute("nota",String.valueOf(a.getNota()));
        rd.forward(request, response);
        banco.desconectar();
    }            
}

