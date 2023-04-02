import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
            Scanner scanL = new Scanner(System.in);
            while (scanL.hasNextLine())
            {
                try {
                    System.out.println("\""+sc(scanL.nextLine())+"\"");
                } catch (Exception e)
                {
                    System.out.println("Метод не прошел: throws Exception");
                    break;
                }
            }
    }
    public static String sc(String s) throws Exception
    {
        String[] kovicki = s.split("\"");
        int plus = s.indexOf("+");
        int minus = s.indexOf("-");
        int multiply = s.indexOf("*");
        int divide = s.indexOf("/");
        String pervoe =  kovicki[1]; //определил первыую строку
        char [] pervoeVMassiv = pervoe.toCharArray();
        int dlinaStrokiPervoe = pervoeVMassiv.length;
        int dlinaArrayPoKovichkam = kovicki.length;

        if (dlinaStrokiPervoe>10)
        {
            System.out.println("ошибка на проверке длины символов первого слова");
            throw new Exception();
        }
        /*if (dlinaStrokiPervoe>10 || dlinaStrokiVtoroe>10)
            {
                System.out.println("ошибка на проверке длины символов первого слова");
                throw new Exception();
            }*/
        // И все же раздели по знаку
        // Далее если не можешь спарсить число, то это хрень
        else if (kovicki.length==4) // если у меня строка и строка
            {
                //  "111" + "222"
                //0 "1  " 2 "3
                String vtoroe = kovicki[3]; //определил вторую строку
                char [] vtoroeVMassiv = vtoroe.toCharArray();
                int dlinaStrokiVtoroe = vtoroeVMassiv.length;
                //System.out.println("Зашел в строка и строка, длина массива по ковычкам " +dlinaArrayPoKovichkam+" первый элемент массива "+ kovicki[0]+" R");
            //String znak = pp[2].trim(); // определил знак
               // System.out.println(pp[1].trim());
               // System.out.println(pp[2].trim());
               // System.out.println(pp[3].trim());
            if (dlinaStrokiVtoroe>10)
                {
                    System.out.println("ошибка на проверке длины символов второго слова");
                    throw new Exception();
                }
            else if (plus!=-1) //складываем
                {
                    System.out.println(kovicki[0]+"!"+kovicki[1]+"!"+kovicki[2]+"!"+kovicki[3]+"!"+ dlinaArrayPoKovichkam);
                    s= pervoe + vtoroe;
                }
            else if (minus!=-1)//вычитаем
                {
                    int x = pervoe.indexOf(vtoroe);
                    if (pervoe.equals(vtoroe))
                        {
                            s=" ";
                        }
                    else if(x!=-1)//есть ли в первой строке вторая
                        {
                            /*String [] pervoeDelimCherezVtoroe = pervoe.split(" ");
                            for (int v=0; v<pervoeDelimCherezVtoroe.length; v++)
                                {
                                    if (pervoeDelimCherezVtoroe[v].equals(vtoroe))
                                        {
                                            //System.out.println(pervoeDelimCherezVtoroe[v]);
                                            pervoeDelimCherezVtoroe[v]=" ";
                                            s = String.join("", pervoeDelimCherezVtoroe);
                                            break;
                                        }
                                }*/
                            String [] pervoeDelimCherezVtoroe = pervoe.split(vtoroe);
                            //s= Arrays.toString(pervoeDelimCherezVtoroe);
                            s = String.join("", pervoeDelimCherezVtoroe);
                            //System.out.println("Вычитание, в первом есть второе строка = " + x);

                        }
                    else //если в первой строке нет второй
                        {
                            s=pervoe;
                        }
                    /*
                    //System.out.println("зашел в операцию минус");
                    //"Erik Marx" - "Marx"
                    String [] probelVpervom = pervoe.split(vtoroe); //разделил первое вырожение на пробелы
                    //System.out.println(probelVpervom[0]+"еще не сравнил второе слово со словами в первом");
                    if (vtoroe.equals(probelVpervom[0].trim()))
                        {
                           s = " "+probelVpervom[1];
                           //System.out.println("Успех");
                        }
                    else if (vtoroe.equals(probelVpervom[1].trim()))
                        {
                            s = probelVpervom[0] + " ";
                        }
                        */
                   /* int m = pervoe.indexOf(vtoroe);
                    if (m==1)
                        {
                            ab = pervoe.split(vtoroe);
                            if (ab[0]!=null)
                            {
                                s= ab[0];
                            }
                            else
                            {
                                throw new Exception();
                            }
                        }
                    else if (m==0)
                        {
                        s=pervoe;
                        }
                        */
                    /*char[] pervoeM = pervoe.toCharArray();
                    char[] vtoroeM = vtoroe.toCharArray();
                    for (int v = 0; v< vtoroeM.length; v++)
                        {
                        for (int i = 0; i < pervoeM.length; i++)
                            {
                            if (vtoroeM[v] == pervoeM[i])
                                {
                                System.out.println(pervoeM[v]);
                                }
                            }
                        }
                    System.out.println(pervoeM[0]+" "+ pervoeM[1]+" "+pervoeM[2]);
                    int op = pervoe.indexOf(vtoroe);

                    s=Integer.toString(op);

                     */
                }
            else
                {
                throw new Exception();
                }
            }
        else if (kovicki.length==3) // если у меня строка и число
            {
                //System.out.println("Зашел в строка и число");
                String znakAndNumber = kovicki[2].trim();
                int chislo = 0;
                // {1}{2}{3}
                //System.out.println(kovicki[0]+"!"+kovicki[1]+"!"+kovicki[2]+"!"+ dlinaArrayPoKovichkam);
                if (multiply!=-1) //умножение
                    {
                        String [] ab = znakAndNumber.split("\\*");
                        chislo = Integer.parseInt(ab[1].trim());
                        if (chislo<1 || chislo>10)
                        {
                            System.out.println("зашел в иф умнжножение и вызвал ошибку");
                            throw new Exception();
                        }
                       // System.out.println(chislo);
                       // System.out.println(dlinaStroki);
                        else
                        {
                            s = pervoe;
                            for (int i = 2; i <= chislo; ++i) {
                                s = s + pervoe;
                            }
                            //System.out.println(s);
                            char [] sVArray = s.toCharArray();
                            char [] promejutochni = new char[40];
                            int dlina4x = sVArray.length;
                            if (dlina4x > 40)
                                {
                                    /*for(int i = 0; i<40;i++)
                                        {
                                            promejutochni[i] = sVArray[i];
                                            //System.out.println(i + promejutochni[i]);
                                            // ищи ответ тут
                                        //https://javarush.com/groups/posts/2347-klass-string-v-java
                                        }
                                    s = String.valueOf(promejutochni) + "...";
                                     */
                                    s=s.substring(0,40)+"...";
                                }
                        }
                    }
                else if (divide!=-1) //деление
                {
                    String [] ab = znakAndNumber.split("/");
                    chislo = Integer.parseInt(ab[1].trim());
                    if (chislo<1 || chislo>10)
                    {
                        System.out.println("Ошибка при делении");
                        throw new Exception();
                    }
                    //System.out.println("делить на " + chislo);
                    //System.out.println("длина строки "+dlinaStroki);
                    int peremennay1 =  dlinaStrokiPervoe / chislo;
                    String peremennay2= "";
                    for (int i = 0; i<peremennay1; i++)
                        {
                            peremennay2 =peremennay2 + pervoeVMassiv[i];
                        }
                    s=peremennay2.trim();
                }
                else
                {
                    System.out.println("Не опознал символ. Длина массива по ковычкам "+dlinaArrayPoKovichkam);
                    throw new Exception();
                }
               // System.out.println(pp[1].trim());
               // System.out.println(pp[2].trim());
            }
        else
        // "jasgdkh" sdjfn " kjdkj"
        //0 " 1    " 2     " 3    " 4 = 5
            {
            System.out.println("Длина массива по ковычкам "+dlinaArrayPoKovichkam+" первый элемент массива "+ kovicki[0]+" R");
            throw new Exception();
            }

        //String znak = pp[2].trim(); // определил знак
        /*int p = s.indexOf("+");

            {
            System.out.println(pervoe);
            System.out.println(znak);

            }*/

        return s;
    }

}