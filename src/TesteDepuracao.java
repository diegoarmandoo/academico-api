import java.util.ArrayList;
import java.util.List;

import br.com.academico.aluno.Aluno;
import br.com.academico.aluno.Nota;

public class TesteDepuracao {
    
    
    public static void main(String[] args) throws Exception {
        
        Aluno aluno = new Aluno();
        List<Nota> notas = new ArrayList<Nota>();
        notas.add(new Nota(2,1));
        notas.add(new Nota(5,2));
        aluno.setNotas(notas);
        aluno.calcularMediaPonderada();
        System.out.println("A média ponderada: " + aluno.getMediaPonderada());
    
    }


}
