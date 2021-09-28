package Quiz_Tabla_Verdad;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.util.Locale;
import java.util.Random;

public class Principal {
    public static String LETRA_GLOBAL[][];

    public static void main(String[] args) {
        //INICIAMOS NUESTRO MÉTODO "LISTA_PREGUNTAS" PARA GUARDADAR LOS EJERCICIOS DENTRO DE LA VARIABLE GLOBAL.
        Lista_Preguntas();

        //CREAMOS NUESTRO PANEL "VENTANA" DONDE LE DAREMOS FUNCIÓN CON MOSTRAR A TRAVÉZ DE ELLA LOS EJERCICIOS.
        JOptionPane Panel = new JOptionPane();

        //EXPLICAR "CONFIRM DIALOG"
        int opcion = Panel.showConfirmDialog(null,"Bemvindo ao Quiz de Tabela de Verdade...\n" +
                                                            "No siguinte Quiz Você terá 5 Perguntas Aleatorias\n"+
                                                            "Para Ganhar deverá acertar 3 das 5\n Começar?...",
                                                            "Introdução",JOptionPane.YES_NO_OPTION,
                                                            JOptionPane.PLAIN_MESSAGE);


        if(opcion == 0){
            Generar_Preguntas(); //EJECUCIÓN DEL MÉTODO GENERAL PREGUNTAS...
        }
        else{
            JOptionPane.showMessageDialog(null,"Cerrando Programa...","Despedida",JOptionPane.PLAIN_MESSAGE);
            }

        JOptionPane.showMessageDialog(null, "Ejercicios Utilizados Fueron retirados de:\n"+
                "https://www.qconcursos.com/questoes-de-concursos/disciplinas/matematica-raciocinio-logico/tabelas-verdade-tautologia-contradicao-e-contingencia/questoes?page=2\n"+
                "https://www.qconcursos.com/questoes-de-concursos/disciplinas/matematica-raciocinio-logico/tabelas-verdade-tautologia-contradicao-e-contingencia/questoes");

    }


    //NUESTRO METODO "GENERAR_PREGUNTAS" EJECUTA LA MUESTRA DE LAS VENTANAS DE LOS EJERCICIOS
    //DONDE CONTROLAMOS CON UN "FOR" LA CANTIDAD DE PREGUNTAS QUE SE REALIZAN EN EL QUIZ, Y ASÍ CALCULAR
    //DENTRO DE DOS ARRAYS CON LAS RESPUESTAS CORRECTAS DE LOS EJERCICIOS Y OTRO CON LAS RESPUESTAS DEL USUARIO
    private static void Generar_Preguntas(){


        Random ram = new Random();
        String respuestas_totales [] = new String[5];
        String respuestas_user [] = new String[5];
        boolean ejecutar = true;

        //INICAMOS EL WHILE DONDE SE EJECUTARÁ LAS VENTANAS CON LOS EJERCICIOS DE LÓGICA
        while (ejecutar == true) {
            for (int x = 0; x < 5; x++) {
                int y = ram.nextInt(9);
                String respuesta1 = JOptionPane.showInputDialog(null, LETRA_GLOBAL[y][0] + "\n" +//0
                                                                        LETRA_GLOBAL[y][1] + "\n" +//01
                                                                        LETRA_GLOBAL[y][2] + "\n" +//02
                                                                        LETRA_GLOBAL[y][3] + "\n" +//03
                                                                        LETRA_GLOBAL[y][4] + "\n" +//04
                                                                        LETRA_GLOBAL[y][5] + "\n" +//05
                                                                        LETRA_GLOBAL[y][6] + "\n" +//06
                                                                        LETRA_GLOBAL[y][7] + "\n" +//07
                                                                        LETRA_GLOBAL[y][8] + "\n" +//08
                                                                        LETRA_GLOBAL[y][9] + "\n" +//09"
                                                                        LETRA_GLOBAL[y][10] + "\n" +//10
                                                                        LETRA_GLOBAL[y][11] + "\n" +//11
                                                                        LETRA_GLOBAL[y][12] + "\n" +//12
                                                                        LETRA_GLOBAL[y][13] + "\n" +//13
                                                                        LETRA_GLOBAL[y][14] + "\n",//14
                                                                "Pregunta " + (x + 1), JOptionPane.PLAIN_MESSAGE);

                respuestas_totales[x] = LETRA_GLOBAL[y][15];
                respuestas_user[x] = respuesta1;
            }



            //********************************************************************************************************//
            //********************************************************************************************************//
            //***********VERIFICACIÓN RESPUESTAS DEL USUARIO CON LAS RESPUESTAS DE LAS PREGUNTAS**********************//
            //********************************************************************************************************//
            //********************************************************************************************************//

            int cant_correctas = 0;
            for (int x = 0; x < 5; x++) {
                respuestas_totales[x] = respuestas_totales[x].toLowerCase();
                respuestas_user[x] = respuestas_user[x].toLowerCase();
                if (respuestas_totales[x].contains(respuestas_user[x])) {
                    System.out.println("Respuestas Pregunta nº " + x + " Correcta");
                    cant_correctas += 1;
                    JOptionPane.showConfirmDialog(null, "Resposta nº " + x + " Correta" + "\nResposta User: " + respuestas_user[x] + "\n Resposta Correta: " + respuestas_totales[x], "Resultado", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    System.out.println("Respuestas Pregunta nº " + x + " Incorrecta");
                    JOptionPane.showConfirmDialog(null, "Resposta nº " + x + " Incorresta" + "\nResposta User: " + respuestas_user[x] + "\n Resposta Correta: " + respuestas_totales[x], "Resultado", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
                }
            }


            //********************************************************************************************************//
            //********************************************************************************************************//
            //******************VERIFICAMOS LA APROBACIÓN DEPENDIENDO DE LA CANTIDAD DE ACIERTOS**********************//
            //********************************************************************************************************//
            //********************************************************************************************************//
            if (cant_correctas > 2) {
                JOptionPane.showMessageDialog(null, "Cantidad de Respuestas mayor a 3\nAprovado", "Aprovacion", JOptionPane.PLAIN_MESSAGE);
                int volver = JOptionPane.showConfirmDialog(null, "Desea Volver a Ejecutar el Quiz?", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (volver == 0) {
                    ejecutar = true;
                }
                else {
                    ejecutar = false;
                }
            }
            else {
                //Mostramos un Mensaje de Dialogo con el resultado y la oportunidad de reiniciar el while de la ejecución del programa...
                JOptionPane.showMessageDialog(null, "Cantidad de Respuestas menor a 3\nReprovado", "Aprovacion", JOptionPane.PLAIN_MESSAGE);
                int volver = JOptionPane.showConfirmDialog(null, "Desea Volver a Ejecutar el Quiz?", "Volver", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (volver == 0) {
                    ejecutar = true;
                }
                else {
                    ejecutar = false;
                }
            }


        }
    }


    //EN ESTE MÉTODO CREARMOS LA LISTA DE PREUNTAS, ASIGNANDOLE A LA VARIABLE "LETRA_GLOBAL" LAS LETRAS CORRESPONDIENTES DE LOS EJERCICIOS
    private  static void Lista_Preguntas (){
        String Letra [][] = new String[10][16];

        Letra [0][0] = "Com relação a estruturas lógicas, lógica de argumentação e lógica proposicional, julgue o item subsequente.";
        Letra [0][1] = "";
        Letra [0][2] = "";
        Letra [0][3] = "";
        Letra [0][4] = "";
        Letra [0][5] = "A proposição [p Ʌ q]  [p V (~q)], em que (~q) denota a negação da proposição q,";
        Letra [0][6] = "só apresenta resultado verdadeiro quando a";
        Letra [0][7] = "proposição p for verdadeira e a proposição q for falsa.";
        Letra [0][8] = "";
        Letra [0][9] = "";
        Letra [0][10] = "";
        Letra [0][11] = "";
        Letra [0][12] = "";
        Letra [0][13] = "";
        Letra [0][14] = "Verdadero ou Falso?";
        Letra [0][15] = "Falso";//Respuesta

        /*************************************************************************************************************/
        Letra [1][0] = "Classifique cada uma das equivalências lógicas (⇔)";
        Letra [1][1] = "a seguir colocando (V) para as verdadeiras e (F) para as falsas.";
        Letra [1][2] = "";
        Letra [1][3] = "";
        Letra [1][4] = "";
        Letra [1][5] = "() ~(p v q) <=> ~p ^ ~q";
        Letra [1][6] = "() p ^ (q v r) <=> (p ^ q) v (p^r)";
        Letra [1][7] = "()p^p <=> ~p";
        Letra [1][8] = "()p ^(pvq) <=> q";
        Letra [1][9] = "";
        Letra [1][10] = "A: V,V,F e F";
        Letra [1][11] = "B: V,V,V e F";
        Letra [1][12] = "C: F,F,F e V";
        Letra [1][13] = "D: F,F,F e V";
        Letra [1][14] = "E: V,F,V e F ";
        Letra [1][15] = "A";//Respuesta
        /*************************************************************************************************************/
        Letra [2][0] = "Considere as proposições P, Q, R e S abaixo:";
        Letra [2][1] = "";
        Letra [2][2] = "";
        Letra [2][3] = "";
        Letra [2][4] = "";
        Letra [2][5] = "P : A ↔ B";
        Letra [2][6] = "Q : A → B";
        Letra [2][7] = "R : B → A";
        Letra [2][8] = "S : (~ A ∨ B) ∧ (~ B ∨ A)";
        Letra [2][9] = "";
        Letra [2][10] = "A:  P e S são proposições equivalentes.";
        Letra [2][11] = "B: ∼P e S são proposições equivalentes.";
        Letra [2][12] = "C: As proposições P e Q∨R são equivalentes.";
        Letra [2][13] = "D: Q∨R e S são proposições equivalentes.";
        Letra [2][14] = "E: A proposição Q∧R é equivalente a negação da proposição P.";
        Letra [2][15] = "A";//Respuesta

        /*************************************************************************************************************/
        Letra [3][0] = "Qual dos itens abaixo corresponde aos valores lógicos (de cima para baixo)";
        Letra [3][1] = "da última coluna da tabela-verdade a seguir?";
        Letra [3][2] = "";
        Letra [3][3] = "";
        Letra [3][4] = "";
        Letra [3][5] = "A|B [(A → B) ∨ (B → A)] ↔ [A ∧ (~ A ∨ A)] V V V F F V F F";
        Letra [3][6] = "";
        Letra [3][7] = "";
        Letra [3][8] = "";
        Letra [3][9] = "";
        Letra [3][10] = "A: F, V, V e V.";
        Letra [3][11] = "B: V, F, F e F.";
        Letra [3][12] = "C: F, V, V e F.";
        Letra [3][13] = "D: V, F, F e V.";
        Letra [3][14] = "E: V, V, F e F.";
        Letra [3][15] = "E";//Respuesta
        /*************************************************************************************************************/
        Letra [4][0] = "Classifique cada uma das afirmativas a seguir colocando (V) para as verdadeiras";
        Letra [4][1] = "e (F) para as falsas.";
        Letra [4][2] = "";
        Letra [4][3] = "";
        Letra [4][4] = "";
        Letra [4][5] = "( ) A negação da negação de uma contradição é uma tautologia. ";
        Letra [4][6] = "( ) Contingência é uma proposição cujo valor lógico é sempre verdadeiro.";
        Letra [4][7] = "( ) A disjunção de uma tautologia com uma contradição é uma contingência.";
        Letra [4][8] = "( ) A proposição composta (A→B)→(B→A) é uma contingência.";
        Letra [4][9] = "Marque a alternativa que contém a sequência CORRETA de preenchimento dos parênteses.";
        Letra [4][10] = "A: V, V, F e F.";
        Letra [4][11] = "B: V, V, F e V.";
        Letra [4][12] = "C: F, F, V e V.";
        Letra [4][13] = "D: F, F, F e V.";
        Letra [4][14] = "E: F, F, V e F.";
        Letra [4][15] = "D";//Respuesta
        /*************************************************************************************************************/
        Letra [5][0] = "Considere A uma proposição falsa e B e C duas proposições verdadeiras.";
        Letra [5][1] = "Qual o valor lógico da proposição D:";
        Letra [5][2] = "[(A∨ ~ B) ↔ (~ C ∧ B)] → [(A ∧ B) ∧ (B ∨ C)]?";
        Letra [5][3] = "";
        Letra [5][4] = "";
        Letra [5][5] = "";
        Letra [5][6] = "";
        Letra [5][7] = "";
        Letra [5][8] = "";
        Letra [5][9] = "";
        Letra [5][10] = "A: D é verdadeiro e falso.";
        Letra [5][11] = "B: Verdadeiro.";
        Letra [5][12] = "C: Não é possível determinar o valor lógico de D.";
        Letra [5][13] = "D: D não tem valor lógico.";
        Letra [5][14] = "E: Falso.";
        Letra [5][15] = "E";//Respuesta
        /*************************************************************************************************************/
        Letra [6][0] = "Classifique cada uma das equivalências lógicas";
        Letra [6][1] = "(a seguir colocando (V) para as verdadeiras e (F) para as falsas ";
        Letra [6][2] = "";
        Letra [6][3] = "";
        Letra [6][4] = "";
        Letra [6][5] = "( ) ~(p ∨ q) ⇔ ~ p∧ ~ q ";
        Letra [6][6] = "( ) p ∧ (q ∨ r) ⇔ (p ∧ q) ∨ (p ∧ r)";
        Letra [6][7] = "( ) p ∧ q ⇔ ~ p";
        Letra [6][8] = "( ) p ∧ (p ∨ q) ⇔ q";
        Letra [6][9] = "Indique a alternativa que contém a sequência CORRETA.";
        Letra [6][10] = "A: V, V, F e F.";
        Letra [6][11] = "B: V, V, V e F.";
        Letra [6][12] = "C: F, F, F e V.";
        Letra [6][13] = "D: F, V, F e V.";
        Letra [6][14] = "E: V, F, V e F.";
        Letra [6][15] = "A";//Respuesta
        /*************************************************************************************************************/
        Letra [7][0] = "Considere as proposições P, Q, R e S abaixo:";
        Letra [7][1] = "";
        Letra [7][2] = "";
        Letra [7][3] = "";
        Letra [7][4] = "P : A ↔ B Q: A → B R: B → A";
        Letra [7][5] = "";
        Letra [7][6] = "S: (~ A ∨ B) ∧ (~ B ∨ A)";
        Letra [7][7] = "";
        Letra [7][8] = "";
        Letra [7][9] = "É CORRETO afirmar que:";
        Letra [7][10] = "A: P e S são proposições equivalentes.";
        Letra [7][11] = "B: ∼P e S são proposições equivalentes.";
        Letra [7][12] = "C: As proposições P e Q∨R são equivalentes.";
        Letra [7][13] = "D: Q∨R e S são proposições equivalentes.";
        Letra [7][14] = "E: A proposição Q∧R é equivalente a negação da proposição P.";
        Letra [7][15] = "A";//Respuesta
        /*************************************************************************************************************/
        Letra [8][0] = "Considere A uma proposição falsa e B e C duas proposições verdadeiras.";
        Letra [8][1] = "";
        Letra [8][2] = "Qual o valor lógico da proposição D :";
        Letra [8][3] = "";
        Letra [8][4] = "";
        Letra [8][5] = "[(A ∨ ~ B) ↔ (~ C ∧ B)] → [(A ∧ B) ∧ (B ∨ C)]?";
        Letra [8][6] = "";
        Letra [8][7] = "";
        Letra [8][8] = "";
        Letra [8][9] = "";
        Letra [8][10] = "A: D é verdadeiro e falso.";
        Letra [8][11] = "B: Verdadeiro.";
        Letra [8][12] = "C: Não é possível determinar o valor lógico de D.";
        Letra [8][13] = "D: D não tem valor lógico.";
        Letra [8][14] = "E: Falso.";
        Letra [8][15] = "E";//Respuesta
        /*************************************************************************************************************/
        Letra [9][0] = "Considere as seguintes premisas:";
        Letra [9][1] = "";
        Letra [9][2] = "• p: a proposição composta p ↔ q V ~q → ~p é uma contradição.";
        Letra [9][3] = "• q: o conjunto-solução da inequação x + 1/x-1 ≤ 0 possui apenas 3 números inteiros.";
        Letra [9][4] = "• r: para quaisquer valores de x, y e z pertencentes aos conjuntos";
        Letra [9][5] = "   dos números inteiros, (x*y - z)/(z + x) sempre será um número inteiro.";
        Letra [9][6] = "→Considerando os valores lógicos das proposições acima apresentadas,";
        Letra [9][7] = "   é correto afirmar que as proposições compostas ";
        Letra [9][8] = "    p Ʌ ~q, q ↔ r, p → r têm,";
        Letra [9][9] = "    respectivamente, os seguintes valores lógicos:";
        Letra [9][10] = "A: falso; falso; e falso.";
        Letra [9][11] = "B: falso; falso; e verdadeiro.";
        Letra [9][12] = "C: falso; verdadeiro; e verdadeiro.";
        Letra [9][13] = "D: verdadeiro; verdadeiro; e falso.";
        Letra [9][14] = "E: verdadeiro; falso; e verdadeiro.";
        Letra [9][15] = "D";//Respuesta
        /*************************************************************************************************************/

        LETRA_GLOBAL = Letra;
    }


    //Las Preguntas Utilizadas para este ejercicio fueron retiradas de:
    // https://www.qconcursos.com/questoes-de-concursos/disciplinas/matematica-raciocinio-logico/tabelas-verdade-tautologia-contradicao-e-contingencia/questoes?page=2
}
