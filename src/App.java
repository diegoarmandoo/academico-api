public class App {
    public static void main(String[] args) throws Exception {
        
        Aluno aluno01 = new Aluno(1234,"Diego Armando", 35, "Informática", "Sergipe", true);
        Aluno aluno02 = new Aluno(3456,"Pedro José", 28, "Comércio", "Riachão do Dantas", false);

        System.out.println(aluno01.toString());
        System.out.println(aluno02.toString());

        Professor professor01 = new Professor(9999,"Maria Conceição", 48, 'F', "999.999.999-99", "Rua B - Bairro B");

        System.out.println(professor01.toString());

    }
}
