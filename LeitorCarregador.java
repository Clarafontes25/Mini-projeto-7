import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LeitorCarregador {

    public HashMap<String, Personagem> lerPersonagens(String caminhoArquivoPersonagens){
    HashMap < String, Personagem > personagens = new HashMap <String,Personagem>();  
File arquivoPersonagens = new File(caminhoArquivoPersonagens);
try {
Scanner escaneadorArquivoPersonagens = new Scanner(arquivoPersonagens,"UTF-8");
String nomePersonagen ="";
String linhaEscaneada =" ";
int energiaPersonagem= 0;
while(escaneadorArquivoPersonagens.hasNextLine()){

while(linhaEscaneada.equals("Personagem")){
}
linhaEscaneada=escaneadorArquivoPersonagens.nextLine();
String nomePersonagem = escaneadorArquivoPersonagens.nextLine();
linhaEscaneada=escaneadorArquivoPersonagens.nextLine();
personagens.put(nomePersonagem,new Personagem(nomePersonagem,energiaPersonagem));

}
escaneadorArquivoPersonagens.close();
} catch (FileNotFoundException exception){
    exception.printStackTrace();

}
return personagens;
}
    public HashMap<String,Capitulo >lerCapitulos(String caminhoArquivoCapitulos,
    HashMap<String,Personagem>personagens, 
    Scanner escaneadorConsole){
        HashMap<String,Capitulo>capitulos =new HashMap<String,Capitulo>();
        File arquivoCapitulos=new File (caminhoArquivoCapitulos);
        try{
            Scanner escaneadorArquivoCapitulos = new Scanner( arquivoCapitulos,"UTF-8");
            String linhaEscaneada ="";
            while(escaneadorArquivoCapitulos.hasNext()){
                while(linhaEscaneada.equals("CAPITULO") &&
                 linhaEscaneada.equals("ESCOLHA")){
                    linhaEscaneada = escaneadorArquivoCapitulos.nextLine();
                 }
                 if (linhaEscaneada.equals("CAPITULO"))
                 {
                lerCapitulos(caminhoArquivoCapitulos, personagens, escaneadorConsole);
                    linhaEscaneada ="";
                }
                else if (linhaEscaneada.equals("ESCOLHA")){
                    lerEscolha(capitulos,escaneadorArquivoCapitulos);
                    linhaEscaneada ="";

                }

            }

        escaneadorArquivoCapitulos.close();
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
        return capitulos;
    }
    /**
     * @param personagens
     * @param escaneadorConsole
     * @param capitulos
     * @param escaneadorArquivoCapitulos
     */
    private void lerCapitulos(HashMap< String , Personagem> personagens,Scanner escaneadorConsole,
   HashMap<String,Capitulo>capitulos,Scanner escaneadorArquivoCapitulos ){
    String nomeCapitulo;
    String textoCapitulo;
    String nomePersonagem;
    int variacaoEnergia;
    String linhaEscaneada;
    linhaEscaneada=escaneadorArquivoCapitulos.nextLine();
    nomeCapitulo=escaneadorArquivoCapitulos.nextLine();
    linhaEscaneada=escaneadorArquivoCapitulos.nextLine();
    nomePersonagem=escaneadorArquivoCapitulos.nextLine();
    linhaEscaneada=escaneadorArquivoCapitulos.nextLine();
    nomePersonagem=escaneadorArquivoCapitulos.nextLine();
    variacaoEnergia =Integer.parseInt(escaneadorArquivoCapitulos.nextLine());
    capitulos.put(nomeCapitulo,new Capitulo(nomeCapitulo,
    textoCapitulo,
    null, personagens.get(nomePersonagem),
    variacaoEnergia,
    escaneadorConsole));
   
   }
   private void lerEscolha(HashMap<String,Capitulo> capitulos,Scanner escaneadorArquivoCapitulos){
    String nomeCapituloOrigem;
    String textoEscolha;
    String nomeCapituloDestino;
    String linhaEscaneada;
    linhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    nomeCapituloOrigem = escaneadorArquivoCapitulos.nextLine();
    linhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    textoEscolha = escaneadorArquivoCapitulos.nextLine();
    linhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    nomeCapituloDestino =  escaneadorArquivoCapitulos.nextLine();
    Capitulo capituloOrigem = capitulos .get (nomeCapituloOrigem);
    Capitulo capituloDestino =capitulos .get(nomeCapituloDestino);
    capituloOrigem.adicionarEscolha(new Escolha (textoEscolha,capituloDestino));




   }
}


